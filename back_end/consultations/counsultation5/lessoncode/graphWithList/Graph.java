package graphWithList;

import java.util.ArrayList;
import java.util.List;

// Класс для представления graph-ического объекта
class Graph {
    // Список списков для представления списка смежности
    List<List<Node>> adjList = new ArrayList<>();

    // Конструктор для построения Graphа
    public Graph(List<Edge> edges) {
        // найти вершину с максимальным номером
        int n = 0;
        for (Edge e : edges) {
            n = Integer.max(n, Integer.max(e.src, e.dest));
        }

        // выделяем память для списка смежности
        for (int i = 0; i <= n; i++) {
            adjList.add(i, new ArrayList<>());
        }

        // добавляем ребра в ориентированный graph
        for (Edge e : edges) {
            // выделяем новый узел в списке смежности от src до dest
            adjList.get(e.src).add(new Node(e.dest, e.weight));

            // раскомментировать строку ниже для неориентированного Graph

            // выделяем новый узел в списке смежности от места назначения до источника
            // adjList.get(e.dest).add(new binareTree.Node(e.src, e.weight));
        }
    }

    // Функция для печати представления списка смежности Graph
    public static void printGraph(Graph graph) {
        int src = 0;
        int n = graph.adjList.size();

        while (src < n) {
            // вывести текущую вершину и все соседние с ней вершины
            for (Node edge : graph.adjList.get(src)) {
                System.out.printf("%d ——> %s\t", src, edge);
            }

            System.out.println();
            src++;
        }
    }
}
