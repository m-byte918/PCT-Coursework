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

	// Members
	public  static Cell[][] maze; // The grid
	private static Cell start;    // Start position
	private static int steps = 0; // Steps taken to solve the maze

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
		clearPath();

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
		steps = 0;

		// Remove previous path
		Cell cell;
		for (int x = 0, y; x < WIDTH; ++x) {
			for (y = 0; y < HEIGHT; ++y) {
				cell = maze[x][y];
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
		Cell end;
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
	
	private static boolean breadthFirstSearch(int sx, int sy) {
		ArrayQueue<Cell> queue = new ArrayQueue<Cell>(WIDTH * HEIGHT);
		boolean solved = false;

		Cell n = queue.enqueue(maze[sx][sy]);

		// Enqueue surrounding nodes
		while(!queue.isEmpty()) {
			if (toggleVisited(n = queue.dequeue()))
				continue;
			if (solved = addDirection(queue, n.x - 1, n.y)) break; // North
			if (solved = addDirection(queue, n.x, n.y + 1)) break; // East
			if (solved = addDirection(queue, n.x + 1, n.y)) break; // South
			if (solved = addDirection(queue, n.x, n.y - 1)) break; // West	
		}
		return solved;
	}

	private static boolean depthFirstSearch(int sx, int sy) {
		ArrayStack<Cell> stacc = new ArrayStack<Cell>(WIDTH * HEIGHT);
		boolean solved = false;

		Cell n = stacc.push(maze[sx][sy]);

		// Push surrounding nodes
		while(!stacc.isEmpty()) {
			if (toggleVisited(n = stacc.pop()))
				continue;
			if (solved = addDirection(stacc, n.x - 1, n.y)) break; // North
			if (solved = addDirection(stacc, n.x, n.y + 1)) break; // East
			if (solved = addDirection(stacc, n.x + 1, n.y)) break; // South
			if (solved = addDirection(stacc, n.x, n.y - 1)) break; // West	
		}
		return solved;
	}

	private static boolean toggleVisited(Cell n) {
		if (n.data == VISITED_CHAR) {
			n.data = UNVISITED_CHAR;
			return true; // Remove already visited path
		}
		if (n.data != START_CHAR) {
			n.data = VISITED_CHAR;
			++steps;
		}
		return false;
	}

	private static boolean addDirection(ArrayStack<Cell> stack, int x, int y) {
		if (x <= -1 || x >= WIDTH || y <= -1 || y >= HEIGHT) {
			return false; // Cell does not exist (out of bounds)
		}
		Cell direction = maze[x][y];
		if (direction.data == UNVISITED_CHAR) {
			stack.push(direction);
		}
		return direction.data == END_CHAR;
	}

	private static boolean addDirection(ArrayQueue<Cell> q, int x, int y) {
		if (x <= -1 || x >= WIDTH || y <= -1 || y >= HEIGHT) {
			return false; // Cell does not exist (out of bounds)
		}
		Cell direction = maze[x][y];
		if (direction.data == UNVISITED_CHAR) {
			q.enqueue(direction);
		}
		return direction.data == END_CHAR;
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
