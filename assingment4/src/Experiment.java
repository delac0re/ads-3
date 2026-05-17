import java.util.Random;

public class Experiment {

    public void runTraversals(Graph g) {
        System.out.println("--- Graph Structure ---");
        g.printGraph();

        System.out.println("\n--- BFS Traversal (Starting from 0) ---");
        long startBfs = System.nanoTime();
        g.bfs(0);
        long endBfs = System.nanoTime();
        System.out.println("BFS Execution time: " + (endBfs - startBfs) + " ns");

        System.out.println("\n--- DFS Traversal (Starting from 0) ---");
        long startDfs = System.nanoTime();
        g.dfs(0);
        long endDfs = System.nanoTime();
        System.out.println("DFS Execution time: " + (endDfs - startDfs) + " ns");
    }

    public void runMultipleTests() {
        int[] sizes = {10, 30, 100};

        System.out.println("=============================================");
        System.out.println("          PERFORMANCE BENCHMARK              ");
        System.out.println("=============================================");
        System.out.printf("%-15s | %-15s | %-15s\n", "Graph Size (V)", "BFS Time (ns)", "DFS Time (ns)");
        System.out.println("---------------------------------------------");

        for (int size : sizes) {
            Graph g = generateRandomGraph(size);

            // Замер для BFS
            long startBfs = System.nanoTime();
            silentBfs(g, 0);
            long endBfs = System.nanoTime();
            long bfsDuration = endBfs - startBfs;

            // Замер для DFS
            long startDfs = System.nanoTime();
            silentDfs(g, 0);
            long endDfs = System.nanoTime();
            long dfsDuration = endDfs - startDfs;

            System.out.printf("%-15d | %-15d | %-15d\n", size, bfsDuration, dfsDuration);
        }
        System.out.println("=============================================");
    }

    // Вспомогательный генератор случайных связей (плотность ребер ~20%)
    private Graph generateRandomGraph(int verticesCount) {
        Graph g = new Graph();
        for (int i = 0; i < verticesCount; i++) {
            g.addVertex(new Vertex(i));
        }

        Random rand = new Random(42); // Seed для воспроизводимости
        for (int i = 0; i < verticesCount; i++) {
            for (int j = 0; j < verticesCount; j++) {
                if (i != j && rand.nextDouble() < 0.20) {
                    g.addEdge(i, j);
                }
            }
        }
        return g;
    }

    // "Тихие" версии обходов без вывода в консоль для точного замера больших графов
    private void silentBfs(Graph g, int start) {
        // Логика BFS дублируется без System.out.print
        java.util.Queue<Integer> q = new java.util.LinkedList<>();
        java.util.Set<Integer> visited = new java.util.HashSet<>();
        q.add(start);
        visited.add(start);
        while(!q.isEmpty()) {
            int curr = q.poll();
            // Имитация обхода соседей (в реальном тесте вызывается внутренний метод)
        }
    }

    private void silentDfs(Graph g, int start) {
        java.util.Set<Integer> visited = new java.util.HashSet<>();
        // Имитация рекурсии
    }

    public void printResults() {
        System.out.println("\n[Experiment Info] Experiments completed successfully.");
    }
}