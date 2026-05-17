public class Main {
    public static void main(String[] args) {
        System.out.println("Starting Assignment 4 (Graphs)...");

        // 1. Создаем демонстрационный маленький граф (10 вершин)
        Graph smallGraph = new Graph();
        for (int i = 0; i < 10; i++) {
            smallGraph.addVertex(new Vertex(i));
        }

        // Добавляем ребра (создаем связную структуру)
        smallGraph.addEdge(0, 1);
        smallGraph.addEdge(0, 2);
        smallGraph.addEdge(1, 3);
        smallGraph.addEdge(1, 4);
        smallGraph.addEdge(2, 5);
        smallGraph.addEdge(2, 6);
        smallGraph.addEdge(3, 7);
        smallGraph.addEdge(4, 8);
        smallGraph.addEdge(5, 9);

        // 2. Запускаем визуализацию трассировки для маленького графа
        Experiment experiment = new Experiment();
        experiment.runTraversals(smallGraph);

        // 3. Запускаем автоматические тесты производительности (10, 30, 100 вершин)
        experiment.runMultipleTests();
        experiment.printResults();
    }
}