import java.util.LinkedList;

public class Graph {
    private LinkedList<Vertex> _vertices;

    public Graph() {
        _vertices = new LinkedList<Vertex>();
    }

    public void addEdge(Vertex origin, Vertex dest, float weight, boolean directed, String name) {
        // Add edge connecting the origin to the  destination
        origin.getEdges().add(new Edge(dest, weight, origin.getName() + "->" + dest.getName()));
        if (!directed) {
        	// Add edge connecting the destination to the origin
        	dest.getEdges().add(new Edge(origin, weight, dest.getName() + "->" + origin.getName()));
        }
    }

    public void addVertex(Vertex v) {
        _vertices.add(v);
    }

    public String dijkstra(Vertex start, Vertex end) {
    	// Reset temporary data from previous calls to this method
    	for (Vertex v : _vertices) {
    		v.mark = false;
    		v.distance = Float.MAX_VALUE;
    		v.prev = null;
    	}
    	// Current will start at the starting vertex
        Vertex curr = _vertices.get(_vertices.indexOf(start));
        curr.distance = 0;
        
        int i;
        Edge edge;
        float calculatedDist;

        while (curr != null && curr != end) {
        	// Get edge with lightest weight/shortest distance
            for (i = 0; i < curr.getEdges().size(); ++i) {
            	edge = curr.getEdges().get(i);

                if (edge.getDest().mark) {
                    continue;
                }
                calculatedDist = curr.distance + edge.getWeight();

                if (calculatedDist < edge.getDest().distance) {
                	edge.getDest().distance = calculatedDist;
                	edge.getDest().prev = curr;
                }
            }
            curr.mark = true;
            edge = _getLightestEdge();
            curr = edge == null ? null : edge.getDest();
        }
        // Walk back from the start of the path
        LinkedList<Vertex> path = new LinkedList<Vertex>();

        while (curr != null) {
            path.push(curr);
            curr = curr.prev;
        }
        StringBuilder builder = new StringBuilder();
        builder.append("Shortest path from " + start.getName() + " to " + end.getName() + "\n");
        builder.append("Start at " + path.pop().getName() + ". Total distance = 0\n");

        while (!path.isEmpty()) {
            curr = path.pop();
            builder.append("Then go to " + curr.getName() + " Total distance = " + curr.distance + "\n");
        }
        return builder.toString();
    }

    private Edge _getLightestEdge() {
        Edge candidate = null;

        for (Vertex v : _vertices) {
            if (!v.mark) {
                continue;
            }
            for (Edge e : v.getEdges()) {
                if ((candidate == null || e.getWeight() < candidate.getWeight()) && !e.getDest().mark)
                    candidate = e;
            }
        }
        return candidate;
    }
}
