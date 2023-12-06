package graphWithList;

import java.util.Arrays;
import java.util.List;


public class GraphExample {
        public static void main (String[] args)
        {
            // Вход: список ребер во взвешенном орграфе (согласно приведенной выше диаграмме)
            // кортеж `(x, y, w)` представляет ребро от `x` до `y`, имеющее вес `w`
            List<Edge> edges = Arrays.asList(
                    new Edge(0, 1, 6), new Edge(1, 2, 7), new Edge(2, 0, 5),
                    new Edge(2, 1, 4), new Edge(3, 2, 10), new Edge(4, 5, 1),
                    new Edge(5, 4, 3));

            // построить graph из заданного списка ребер
            Graph graph = new Graph(edges);

            // вывести представление списка смежности Graph
            Graph.printGraph(graph);
        }

}
