package basicAlgorithm.graph.defineGraph;

public class TestGraph {
    public static void main(String[] args) {
        Graph graph = new SparseGraph(13);
        int[][] a = {{0, 5}, {4, 3}, {0, 1}, {9, 12}, {6, 4}, {5, 4}, {0, 2}, {11, 12}, {9, 10}, {0, 6}, {7, 8}, {9, 11}, {5, 3}};
        for (int[] ints : a) {
            graph.addEdge(ints[0], ints[1]);
        }
        graph.show();

        Graph graph2 = new DenseGraph(13);
        int[][] a2 = {{0, 5}, {4, 3}, {0, 1}, {9, 12}, {6, 4}, {5, 4}, {0, 2}, {11, 12}, {9, 10}, {0, 6}, {7, 8}, {9, 11}, {5, 3}};
        for (int[] ints : a2) {
            graph2.addEdge(ints[0], ints[1]);
        }
        graph2.show();
    }

}
