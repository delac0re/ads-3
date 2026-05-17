import java.util.*;

public class Graph {
    private final Map<Vertex, List<Edge>> adjacencyList;

    public Graph() {
        this.adjacencyList = new LinkedHashMap<>();
    }

    public void addVertex(Vertex v) {
        adjacencyList.putIfAbsent(v, new ArrayList<>());
    }

    public void addEdge(int from, int to) {
        Vertex source = new Vertex(from);
        Vertex destination = new Vertex(to);

        // Убедимся, что вершины существуют в графе
        addVertex(source);
        addVertex(destination);

        // Для поиска ключа в Map (чтобы использовать существующие объекты)
        adjacencyList.get(source).add(new Edge(source, destination));

        // Если вам нужен НЕориентированный граф, раскомментируйте строчку ниже:
        // adjacencyList.get(destination).add(new Edge(destination, source));
    }

    public void printGraph() {
        for (Map.Entry<Vertex, List<Edge>> entry : adjacencyList.entrySet()) {
            System.out.print("Vertex " + entry.getKey() + ": ");
            for (Edge edge : entry.getValue()) {
                System.out.print(edge.getDestination() + " ");
            }
            System.out.println();
        }
    }

    // Алгоритм Breadth-First Search (BFS)
    public void bfs(int start) {
        Vertex startVertex = new Vertex(start);
        if (!adjacencyList.containsKey(startVertex)) {
            System.out.println("Start vertex not found.");
            return;
        }

        Set<Vertex> visited = new HashSet<>();
        Queue<Vertex> queue = new LinkedList<>();

        visited.add(startVertex);
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            Vertex current = queue.poll();
            System.out.print(current + " ");

            List<Edge> edges = adjacencyList.get(current);
            if (edges != null) {
                for (Edge edge : edges) {
                    Vertex neighbor = edge.getDestination();
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
        }
        System.out.println();
    }

    // Алгоритм Depth-First Search (DFS)
    public void dfs(int start) {
        Vertex startVertex = new Vertex(start);
        if (!adjacencyList.containsKey(startVertex)) {
            System.out.println("Start vertex not found.");
            return;
        }

        Set<Vertex> visited = new HashSet<>();
        dfsHelper(startVertex, visited);
        System.out.println();
    }

    private void dfsHelper(Vertex current, Set<Vertex> visited) {
        visited.add(current);
        System.out.print(current + " ");

        List<Edge> edges = adjacencyList.get(current);
        if (edges != null) {
            for (Edge edge : edges) {
                Vertex neighbor = edge.getDestination();
                if (!visited.contains(neighbor)) {
                    dfsHelper(neighbor, visited);
                }
            }
        }
    }
}