
public class FloodFill {
	private final static int WIDTH  = 16;
	private final static int HEIGHT = 16;

	public static void main(String[] args) {
		Node[][] maze = buildMaze();
		printMaze(maze);
		
		//floodFill(maze, WIDTH / 2, HEIGHT / 2);
		depthFirstSearch(maze, WIDTH / 2, HEIGHT / 2);
		printMaze(maze);
	}

	private static void floodFill(Node[][] maze, int sRow, int sCol) {
		ArrayQueue<Node> q = new ArrayQueue<Node>(WIDTH * HEIGHT);

		maze[sRow][sCol].data = 0;
		q.enqueue(maze[sRow][sCol]);
		
		int dist = 0;
		Node n = null;

		// Enqueue surrounding nodes
		while(!q.isEmpty()) {
			n = q.dequeue();
			dist = n.data;

			if (n.row - 1 > -1)     enqueueDirection(maze[n.row - 1][n.col], q, dist); // Up
			if (n.row + 1 < HEIGHT) enqueueDirection(maze[n.row + 1][n.col], q, dist); // Down
			if (n.col - 1 > -1)     enqueueDirection(maze[n.row][n.col - 1], q, dist); // Left
			if (n.col + 1 < WIDTH)  enqueueDirection(maze[n.row][n.col + 1], q, dist); // Right
		}
	}
	
	private static void enqueueDirection(Node direction, ArrayQueue<Node> q, int dist) {
		if (direction.data == -1) {
			direction.data = dist + 1;
			q.enqueue(direction);
		}
	}
	
	private static void depthFirstSearch(Node[][] maze, int sRow, int sCol) {
		ArrayStack<Node> stacc = new ArrayStack<Node>(WIDTH * HEIGHT);

		maze[sRow][sCol].data = 0;
		stacc.push(maze[sRow][sCol]);
		
		int dist = 0;
		Node n = null;
		
		// Enqueue surrounding nodes
		while(!stacc.isEmpty()) {
			n = stacc.pop();
			dist = n.data;

			if (n.row - 1 > -1)     pushDirection(maze[n.row - 1][n.col], stacc, dist); // Up
			if (n.row + 1 < HEIGHT) pushDirection(maze[n.row + 1][n.col], stacc, dist); // Down
			if (n.col - 1 > -1)     pushDirection(maze[n.row][n.col - 1], stacc, dist); // Left
			if (n.col + 1 < WIDTH)  pushDirection(maze[n.row][n.col + 1], stacc, dist); // Right
		}
	}

	private static void pushDirection(Node direction, ArrayStack<Node> stack, int dist) {
		if (direction.data == -1) {
			direction.data = dist + 1;
			stack.push(direction);
		}
	}
	
	private static Node[][] buildMaze() {
		Node[][] maze = new Node[WIDTH][HEIGHT];
		
		for (int row = 0, col; row < maze.length; ++row) {
			for (col = 0; col < maze[row].length; ++col) {
				maze[row][col] = new Node(row, col, -1);
			}
		}
		return maze;
	}

	private static void printMaze(Node[][] maze) {
		int digits = String.valueOf(WIDTH * HEIGHT).length();
		String format = "%" + digits + "s";
		for (int row = 0, col; row < maze.length; ++row) {
			for (col = 0; col < maze[row].length; ++col) {
				System.out.printf(format, maze[row][col]);
			}
			System.out.println();
		}
	}
}
