# ads-3
for AITU!
Graph Algorithms: Traversal and Shortest Path
This repository contains a Java implementation of a directed graph using an Adjacency List. The project demonstrates fundamental graph traversal techniques alongside an optimized shortest path algorithm added as part of the bonus assignment.

Project Structure
Vertex.java – Core data unit representing a single node with a unique integer ID. It overrides equals() and hashCode() to ensure safe node tracking inside Java collections.
Edge.java – Represents a directed link from a source vertex to a destination vertex. It includes a weight field to store edge costs.
Graph.java – The main management class. It initializes the adjacency list, handles graph construction, and encapsulates all search and traversal algorithms.
Main.java – Entry point that builds a sample graph to demonstrate the correct output sequences for all algorithms.
Experiment.java – Performance benchmark module that dynamically runs the traversals on random graphs of sizes 10, 30, and 100 to analyze execution speeds.

Core Implementations
1. Breadth-First Search (BFS)
   Logic: Explores the graph layer by layer, visiting all immediate neighbors before moving deeper.
   Mechanism: Implemented using a standard Queue (FIFO workflow) and a HashSet to log visited nodes, successfully avoiding infinite loops in cyclic structures.
2. Depth-First Search (DFS)
   Logic: Dives as deeply as possible down a single branch until it hits a dead-end, then backtracks to the most recent choice point.
   Mechanism: Implemented using recursion. It implicitly leverages the internal JVM system call stack to handle backtracking automatically without requiring manual stack management.
   
Bonus Task: Dijkstra's Algorithm
As required by the bonus guidelines, the graph structure was extended to support weighted directed edges, and a custom shortest path solver was integrated into the system.

Implementation Details
Edge Modification: The Edge class was updated to contain an int weight field, representing the exact movement cost between connected nodes.
Algorithm Logic: The dijkstra(int startId) method calculates the absolute shortest path from a given starting vertex to every other accessible node. It operates on a greedy optimization model: it consistently picks the unvisited node with the lowest current distance and immediately updates (relaxes) the cumulative distance to all its surrounding neighbors.
Constraint Adherance: Following the specific assignment guidelines, the algorithm relies entirely on simple nested loops and primitive tracking arrays (int[] distances and boolean[] visited) instead of a PriorityQueue.

Complexity Analysis
Because the implementation avoids a heap-based priority queue and utilizes standard sequential loops to search for the next minimum distance vertex, the theoretical time complexity for this specific implementation is O(V^2), where V represents the total number of vertices in the graph. This is highly efficient and optimal for the specified project scope.
