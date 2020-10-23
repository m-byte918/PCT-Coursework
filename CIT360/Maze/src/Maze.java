import java.util.concurrent.ThreadLocalRandom;

public class Maze {

	// Configurations
	public  final static int  WIDTH          = 32;
	public  final static int  HEIGHT         = 16;
	private final static char WALL_CHAR      = '▓';
	private final static char START_CHAR     = 'S';
	private final static char END_CHAR       = 'E';
	private final static char VISITED_CHAR   = '.';
	public  final static char UNVISITED_CHAR = ' ';
	private final static char MIN_PATH_CHAR  = '*';

	// Members
	public  static Cell[][] maze;   // The grid
	private static Cell start, end; // Start and end cells
	private static int steps = 0;   // Steps taken to solve the maze

	public static void main(String[] args) throws Exception {
		initMaze();
		carvePath(WIDTH / 2, HEIGHT / 2);

		System.out.println("Unsolved maze:");
		printMaze();

		/***** DEPTH FIRST SEARCH *****/

		System.out.print("Depth first search: ");
		if (depthFirstSearch(start.x, start.y)) {
			System.out.printf("solved in %d steps\n", steps);
		} else {
			System.out.println("unsolvable :c");
		}
		printMaze();
		
		// Reset
		clearPath();
		steps = 0;

		/***** BREADTH FIRST SEARCH *****/
		
		System.out.print("Breadth first search: ");
		if (breadthFirstSearch(start.x, start.y)) {
			System.out.printf("solved in %d steps\n", steps);
		} else {
			System.out.println("unsolvable :c");
		}
		printMaze();
	}
	
	private static void clearPath() {
		// Remove previous path
		Cell cell;
		for (int x = 0, y; x < WIDTH; ++x) {
			for (y = 0; y < HEIGHT; ++y) {
				cell = maze[x][y];
				cell.dist = 0;
				if (cell.data == VISITED_CHAR)
					cell.data = UNVISITED_CHAR;
			}
		}
	}

	private static void initMaze() {
		maze = new Cell[WIDTH][HEIGHT];

		// Fill maze with walls
		for (int x = 0, y; x < WIDTH; ++x) {
			for (y = 0; y < HEIGHT; ++y)
				maze[x][y] = new Cell(x, y, WALL_CHAR);
		}
	}

	// Randomized depth-first search algorithm
	// Does not allow for 'density' sorry :c
	private static void carvePath(int x, int y) throws Exception {
		ArrayStack<Cell> stack = new ArrayStack<Cell>(WIDTH * HEIGHT);

		Cell chosen, current = maze[x][y]; // Choose initial cell
		current.data = UNVISITED_CHAR; 	   // Mark as part of path
		stack.push(current); 			   // Push to stack

		while (!stack.isEmpty()) {
			current = stack.pop();
			chosen = current.getRandomNeighbor();

			if (chosen != null) {
				stack.push(current);
				stack.push(chosen);
				chosen.data = UNVISITED_CHAR;
			}
		}
		// Pick start/end points
		do {
			end = getRandomEndpoint();
			start = getRandomEndpoint();
		}
		while (end == start);
		end.data = END_CHAR;
		start.data = START_CHAR;
	}
	
	private static Cell getRandomEndpoint() {
		if (ThreadLocalRandom.current().nextBoolean()) {
			int ry = ThreadLocalRandom.current().nextInt(1, HEIGHT - 1);
			if (ThreadLocalRandom.current().nextBoolean()) {
				// West wall
				maze[1][ry].data = UNVISITED_CHAR;
				return maze[0][ry];
			} else {
				// East wall
				maze[WIDTH - 2][ry].data = UNVISITED_CHAR;
				return maze[WIDTH - 1][ry];
			}
		} else {
			int rx = ThreadLocalRandom.current().nextInt(1, WIDTH - 1);
			if (ThreadLocalRandom.current().nextBoolean()) {
				// North wall
				maze[rx][1].data = UNVISITED_CHAR;
				return maze[rx][0];
			} else {
				// South wall
				maze[rx][HEIGHT - 2].data = UNVISITED_CHAR;
				return maze[rx][HEIGHT - 1];
			}
		}
	}
	
	private static boolean breadthFirstSearch(int sx, int sy) throws Exception {
		ArrayQueue<Cell> queue = new ArrayQueue<Cell>(WIDTH * HEIGHT);
		boolean solved = false;

		Cell n = queue.enqueue(maze[sx][sy]);
		int dist = 0;

		// Enqueue surrounding nodes
		while(!queue.isEmpty()) {
			if (toggleVisited(n = queue.dequeue()))
				continue;
			dist = n.dist;
			if (solved = addDirection(queue, n.x, n.y - 1, dist)) break; // North
			if (solved = addDirection(queue, n.x + 1, n.y, dist)) break; // East
			if (solved = addDirection(queue, n.x, n.y + 1, dist)) break; // South
			if (solved = addDirection(queue, n.x - 1, n.y, dist)) break; // West
		}
		// Traverse backward through maze to get the shortest path
		if (solved) {
			(n = end).dist = dist + 1; // End has highest distance
			Cell m = null; // Temp
			while (n != start) {
				dist = n.dist;
				if      ((m = addMinPath(n.x, n.y - 1, dist)) != null) n = m; // North
				else if ((m = addMinPath(n.x + 1, n.y, dist)) != null) n = m; // East
				else if ((m = addMinPath(n.x, n.y + 1, dist)) != null) n = m; // South
				else if ((m = addMinPath(n.x - 1, n.y, dist)) != null) n = m; // West
			} 
			clearPath(); // Remove everything but the minimum path
		}
		return solved;
	}

	private static Cell addMinPath(int x, int y, int dist) {
		if (!Cell.existsAt(x, y)) {
			return null;
		}
		Cell direction = maze[x][y];
		if (direction.dist >= dist) {
			return null; // Dist must be less than current
		}
		if (direction.data == VISITED_CHAR) {
			direction.data = MIN_PATH_CHAR;
			return direction;
		}
		return direction == start ? direction : null;
	}

	private static boolean depthFirstSearch(int sx, int sy) {
		ArrayStack<Cell> stacc = new ArrayStack<Cell>(WIDTH * HEIGHT);

		Cell n = stacc.push(maze[sx][sy]);

		// Push surrounding nodes
		while(!stacc.isEmpty()) {
			if (toggleVisited(n = stacc.pop()))
				continue;
			if (addDirection(stacc, n.x, n.y - 1)) return true; // North	
			if (addDirection(stacc, n.x + 1, n.y)) return true; // East
			if (addDirection(stacc, n.x, n.y + 1)) return true; // South
			if (addDirection(stacc, n.x - 1, n.y)) return true; // West
		}
		return false;
	}

	private static boolean toggleVisited(Cell n) {
		if (n.data == VISITED_CHAR) {
			//n.data = UNVISITED_CHAR;
			return true; // Remove already visited path
		}
		if (n.data != START_CHAR) {
			n.data = VISITED_CHAR;
			++steps;
		}
		return false;
	}

	private static boolean addDirection(ArrayStack<Cell> stack, int x, int y) {
		if (!Cell.existsAt(x, y)) {
			return false;
		}
		Cell direction = maze[x][y];
		if (direction.data == UNVISITED_CHAR) {
			stack.push(direction);
		}
		return direction == end;
	}

	private static boolean addDirection(ArrayQueue<Cell> q, int x, int y, int dist) {
		if (!Cell.existsAt(x, y)) {
			return false;
		}
		Cell direction = maze[x][y];
		if (direction.data == UNVISITED_CHAR) {
			if (direction.dist == 0) {
				// Only modify non-modified distance
				direction.dist = dist + 1;
			}
			q.enqueue(direction);
		}
		return direction == end;
	}

	private static void printMaze() {
		StringBuilder sb = new StringBuilder();

		for (int y = 0, x; y < HEIGHT; ++y) {
			for (x = 0; x < WIDTH; ++x) {
				sb.append(maze[x][y].data);
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}
