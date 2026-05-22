import java.util.*;

public class Graph {
    private Map<Vertex, List<Edge>> adjList;

    public Graph() {
        this.adjList = new LinkedHashMap<>();
    }

    public void addVertex(Vertex vertex) {
        adjList.putIfAbsent(vertex, new ArrayList<>());
    }

    public void addEdge(Vertex source, Vertex destination, int weight) {
        if (!adjList.containsKey(source)) addVertex(source);
        if (!adjList.containsKey(destination)) addVertex(destination);
        adjList.get(source).add(new Edge(source, destination, weight));
    }

    public void bfs(int startId) {
        Vertex startVertex = new Vertex(startId);
        if (!adjList.containsKey(startVertex)) return;

        Queue<Vertex> queue = new LinkedList<>();
        Set<Vertex> visited = new HashSet<>();

        queue.add(startVertex);
        visited.add(startVertex);

        System.out.println("BFS Traversal starting from vertex " + startId + ":");
        while (!queue.isEmpty()) {
            Vertex current = queue.poll();
            System.out.print(current.getId() + " ");

            for (Edge edge : adjList.get(current)) {
                Vertex neighbor = edge.getDestination();
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    public void dfs(int startId) {
        Vertex startVertex = new Vertex(startId);
        if (!adjList.containsKey(startVertex)) return;

        Set<Vertex> visited = new HashSet<>();
        System.out.println("DFS Traversal starting from vertex " + startId + ":");
        dfsHelper(startVertex, visited);
        System.out.println();
    }

    private void dfsHelper(Vertex vertex, Set<Vertex> visited) {
        visited.add(vertex);
        System.out.print(vertex.getId() + " ");

        for (Edge edge : adjList.get(vertex)) {
            Vertex neighbor = edge.getDestination();
            if (!visited.contains(neighbor)) {
                dfsHelper(neighbor, visited);
            }
        }
    }

    public void dijkstra(int startId) {
        int verticesCount = adjList.size();
        int[] distances = new int[verticesCount];
        boolean[] visited = new boolean[verticesCount];

        for (int i = 0; i < verticesCount; i++) {
            distances[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }
        distances[startId] = 0;

        for (int count = 0; count < verticesCount - 1; count++) {
            int minDistance = Integer.MAX_VALUE;
            int minVertexId = -1;

            for (int v = 0; v < verticesCount; v++) {
                if (!visited[v] && distances[v] <= minDistance) {
                    minDistance = distances[v];
                    minVertexId = v;
                }
            }

            if (minVertexId == -1) break;

            visited[minVertexId] = true;
            Vertex currentVertex = new Vertex(minVertexId);

            if (adjList.containsKey(currentVertex)) {
                for (Edge edge : adjList.get(currentVertex)) {
                    int neighborId = edge.getDestination().getId();
                    if (!visited[neighborId] && distances[minVertexId] != Integer.MAX_VALUE) {
                        int newDistance = distances[minVertexId] + edge.getWeight();
                        if (newDistance < distances[neighborId]) {
                            distances[neighborId] = newDistance;
                        }
                    }
                }
            }
        }

        System.out.println("\n--- Dijkstra Shortest Paths from Vertex " + startId + " ---");
        for (int i = 0; i < verticesCount; i++) {
            if (distances[i] == Integer.MAX_VALUE) {
                System.out.println("To Vertex " + i + " : Unreachable");
            } else {
                System.out.println("To Vertex " + i + " : Shortest Distance = " + distances[i]);
            }
        }
    }

    public void printGraph() {
        System.out.println("Graph Structure (Adjacency List):");
        for (Map.Entry<Vertex, List<Edge>> entry : adjList.entrySet()) {
            System.out.print(entry.getKey().getId() + ": [");
            List<Edge> edges = entry.getValue();
            for (int i = 0; i < edges.size(); i++) {
                System.out.print(edges.get(i).getDestination().getId() + "(w:" + edges.get(i).getWeight() + ")");
                if (i < edges.size() - 1) System.out.print(", ");
            }
            System.out.println("]");
        }
    }
}