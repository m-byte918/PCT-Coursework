/**
 * Edge representation that is weighted and has only one direction
 */

public class Edge {
    private float _weight = 0f;
    private Vertex _dest = null;
    private String _name = "";

    public Edge(Vertex dest, float w, String name) {
        _weight = w;
        _dest = dest;
        _name = name;
    }

    public float getWeight() {
        return _weight;
    }

    public Vertex getDest() {
        return _dest;
    }

    public String getName() {
        return _name;
    }
}
