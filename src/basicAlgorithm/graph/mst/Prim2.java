package basicAlgorithm.graph.mst;

import graph.defineGraph.Edge;
import graph.defineGraph.Graph;
import graph.defineGraph.SparseGraph;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * 纯数组版(效率没有用堆实现的效率高)
 */
public class Prim2 {

    private static void visit(int v, Graph graph, boolean[] marked, Edge[] pq) {
        marked[v] = true;
        for (Edge edge : graph.getAdjEdges(v)) {
            int i = edge.getVerto();
            if (!marked[i]) {
                if (pq[i] == null) {
                    pq[i] = edge;
                } else {
                    if (edge.getWeight() < pq[i].getWeight()) {
                        pq[i] = edge;
                    }
                }
            }
        }
    }

    private static Edge pollMin(Edge[] edges) {
        Edge minEdge = null;
        int index = 0;

        for (int i = 0; i < edges.length; i++) {
            if (edges[i] != null) {
                minEdge = edges[i];
                index = i;
                break;
            }
        }
        for (int i = index + 1; i < edges.length; i++) {
            if (edges[i] != null && edges[i].compareTo(minEdge) < 0) {
                minEdge = edges[i];
                index = i;
            }
        }

        edges[index] = null;
        return minEdge;
    }

    public static List<Edge> mst(Graph graph) {
        Edge[] pq = new Edge[graph.V()];//待选边
        boolean[] marked = new boolean[graph.V()];//节点是否已经加入树中
        List<Edge> mst = new ArrayList<>();//最小生成树的所有边的集合

        visit(0, graph, marked, pq);
        while (mst.size() < graph.V() - 1) {
            Edge minEdge = pollMin(pq);
            mst.add(minEdge);
            visit(minEdge.getVerto(), graph, marked, pq);
        }

        return mst;

    }

    public static double getWeight(List<Edge> mst) {
        double weight = 0;//最小生成树的总权值
        for (Edge edge : mst) {
            weight = weight + edge.getWeight();
        }
        return weight;
    }


    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("src/graph/mst/mst.txt"));

        int vNum = Integer.parseInt(lines.get(0).split(" ")[0]);
        int eNum = Integer.parseInt(lines.get(0).split(" ")[1]);

        Graph graph = new SparseGraph(vNum, false);

        for (int i = 1; i < lines.size(); i++) {
            String[] strs = lines.get(i).split(" ");
            graph.addEdge(Integer.valueOf(strs[0]), Integer.valueOf(strs[1]), Double.valueOf(strs[2]));
        }

        double startTime = System.currentTimeMillis();   //获取开始时间
        List<Edge> mst = mst(graph);
        double endTime = System.currentTimeMillis(); //获取结束时间

        System.out.println("Test Prim2 MST:");
        for (int i = 0; i < mst.size(); i++) {
            mst.get(i).show();
            System.out.println();
        }

        System.out.println("The MST weight is: " + getWeight(mst));

        System.out.println("程序运行时间： " + (endTime - startTime) / 1000 + "s");
    }


}
