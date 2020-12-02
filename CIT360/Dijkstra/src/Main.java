import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(new File("map.dat"));
        Graph graph = new Graph();

        // Vertices
        int i = 0, l = scanner.nextInt();
        Vertex[] vertices = new Vertex[l];
        String[] split;
        Vertex v, d;
        scanner.nextLine(); // Advance
        for (; i < l; ++i) {
            split = scanner.nextLine().split(",");
            v     = new Vertex(split[4]);             // split[4] = name
            v.x   = Float.parseFloat(split[1]);       // split[1] = longitude
            v.y   = Float.parseFloat(split[2]);       // split[2] = latitude
            Float.parseFloat(split[3]);               // split[3] = height
            vertices[Integer.parseInt(split[0])] = v; // split[0] = id
            graph.addVertex(v);
        }

        // Edges
        l = scanner.nextInt();
        scanner.nextLine(); // Advance
        for (i = 0; i < l; ++i) {
            split = scanner.nextLine().split(" ");
            graph.addEdge(
                v = vertices[Integer.parseInt(split[0])], // split[0] = origin index
                d = vertices[Integer.parseInt(split[1])], // split[1] = destination index
                (float)distance(v, d),      			  // weight   = distance in km
                Integer.parseInt(split[2]) == 1,          // split[2] = directed (if 1)
                ""
            );
        }

        FileWriter writer = new FileWriter("directions.dat");
        writer.write(""); // Clear whatever is inside first

        // Test cases
        l = scanner.nextInt();
        scanner.nextLine(); // Advance
        String directions = null;
        for (i = 0; i < l; ++i) {
            split = scanner.nextLine().split(" ");
            directions = graph.dijkstra(
                vertices[Integer.parseInt(split[0])], // split[0] = origin index
                vertices[Integer.parseInt(split[1])]  // split[1] = destination index
            );
            System.out.println(directions);   // Write to console
            writer.append(directions + "\n"); // Write to file
        }
        scanner.close();
        writer.close();
    }

    // https://stackoverflow.com/questions/3694380/calculating-distance-between-two-points-using-latitude-longitude
    private static double distance(Vertex o, Vertex d) {
        double theta = Math.cos(Math.toRadians(o.y - d.y));
        double lat1rad = Math.toRadians(o.x);
        double lat2rad = Math.toRadians(d.x);
        double dist = Math.sin(lat1rad) * Math.sin(lat2rad) + Math.cos(lat1rad) * Math.cos(lat2rad) * theta;
        dist = Math.acos(dist) * Math.toDegrees(dist);
        dist *= 60 * 1.1515 * 1.609344; // (Minutes per degree) * (statute miles per nautical mile) * (kilometers per mile)
        return dist;
    }
}
