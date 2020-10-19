
public class Node {
	public int row;
	public int col;
	public int data;

	Node(int r, int c, int d) {
		row  = r;
		col  = c;
		data = d;
	}
	
	public String toString() {
		return new StringBuilder().append(data).toString();
	}
}
