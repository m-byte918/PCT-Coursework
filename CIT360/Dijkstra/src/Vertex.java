import java.util.LinkedList;

public class Vertex {
    private String _name;
    private LinkedList<Edge> _edges;

    // Temporary data used by dijkstra
    public boolean mark = false;
    public float distance = Float.MAX_VALUE;
    public Vertex prev = null;

    public float x = 0f; // Course grid coordinates
    public float y = 0f; // Course grid coordinates

    public Vertex(String name) {
        _name  = name;
        _edges = new LinkedList<Edge>();
    }

    public String getName() {
        return _name;
    }

    public LinkedList<Edge> getEdges() {
        return _edges;
    }
}
