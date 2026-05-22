import java.util.*;

public class Experiment {
    public static void main(String[] args) {
        int[] sizes = {10, 30, 100};

        System.out.printf("%-15s %-15s %-15s\n", "Graph Size", "BFS Time (ns)", "DFS Time (ns)");
        System.out.println("-------------------------------------------------------");

        for (int size : sizes) {
            Graph g = generateRandomGraph(size);

            long startBfs = System.nanoTime();
            g.bfs(0);
            long endBfs = System.nanoTime();
            long bfsTime = endBfs - startBfs;

            long startDfs = System.nanoTime();
            g.dfs(0);
            long endDfs = System.nanoTime();
            long dfsTime = endDfs - startDfs;

            System.out.printf("%-15d %-15d %-15d\n", size, bfsTime, dfsTime);
        }
    }

    private static Graph generateRandomGraph(int size) {
        Graph g = new Graph();
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            g.addVertex(new Vertex(i));
        }

        for (int i = 0; i < size; i++) {
            int edgesCount = random.nextInt(3) + 1;
            for (int e = 0; e < edgesCount; e++) {
                int j = random.nextInt(size);
                if (i != j) {
                    int weight = random.nextInt(10) + 1;
                    g.addEdge(new Vertex(i), new Vertex(j), weight);
                }
            }
        }
        return g;
    }
}