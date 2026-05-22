import java.util.*;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();

        Vertex v0 = new Vertex(0);
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);
        Vertex v5 = new Vertex(5);

        graph.addVertex(v0);
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);
        graph.addVertex(v5);

        graph.addEdge(v0, v1, 2);
        graph.addEdge(v0, v2, 4);
        graph.addEdge(v1, v3, 1);
        graph.addEdge(v1, v4, 7);
        graph.addEdge(v2, v4, 3);
        graph.addEdge(v3, v5, 5);
        graph.addEdge(v4, v5, 1);

        graph.printGraph();
        System.out.println();

        graph.bfs(0);
        System.out.println();

        graph.dfs(0);
        System.out.println();

        graph.dijkstra(0);
    }
}