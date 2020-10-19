import java.util.concurrent.ThreadLocalRandom;

public class Cell {
	public int x;
	public int y;
	public char data;

	Cell(int x, int y, char data) {
		this.x = x;
		this.y = y;
		this.data = data;
	}

	public LinkedList<Cell> getPossibleNeighbors(boolean recursive) {
		LinkedList<Cell> neighbors = new LinkedList<Cell>();

		addDirection(neighbors, x, y - 1, recursive); // North
		addDirection(neighbors, x + 1, y, recursive); // East
		addDirection(neighbors, x, y + 1, recursive); // South
		addDirection(neighbors, x - 1, y, recursive); // West

		return neighbors;
	}

	public Cell getRandomNeighbor() throws Exception {
		LinkedList<Cell> neighbors = getPossibleNeighbors(false);

		int size = (int)neighbors.size();
		if (size == 0) {
			return null;
		}
		int randomIndex = ThreadLocalRandom.current().nextInt(0, size);
		return neighbors.get(randomIndex); // Return random neighbor
	}

	private void addDirection(LinkedList<Cell> list, int x, int y, boolean recursive) {
		if (x <= -1 || x >= Maze.WIDTH || y <= -1 || y >= Maze.HEIGHT) {
			// Direction does not exist (out of bounds)
			return;
		}
		Cell direction = Maze.maze[x][y];
		if (direction.data == Maze.UNVISITED_CHAR) {
			return; // Cell was already visited
		}
		// Only add direction if it will not create a hole in the path
		if (recursive || direction.getPossibleNeighbors(true).size() >= 3)
			list.addLast(direction);
	}
}
