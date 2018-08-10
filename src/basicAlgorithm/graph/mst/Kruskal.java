package basicAlgorithm.graph.mst;

import graph.defineGraph.Edge;
import graph.defineGraph.Graph;
import graph.defineGraph.SparseGraph;
import unionFind.UnionFind;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * O(E*logE)
 */
public class Kruskal {
    private List<Edge> mst;
    private double weight;//最小生成树的总权值

    public Kruskal(Graph graph) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();//所有边的优先队列
        mst = new ArrayList<>(graph.V() - 1);
        for (int i = 0; i < graph.V(); i++) {
            List<Edge> adjEdges = graph.getAdjEdges(i);
            for (Edge adjEdge : adjEdges) {
                if (adjEdge.getVerfrom() < adjEdge.getVerto()) {
                    pq.offer(adjEdge);
                }
            }
        }
        mst(pq);
    }

    public void mst(PriorityQueue<Edge> pq) {
        int vNum = pq.size();
        UnionFind uf = new UnionFind(vNum);

        while (!pq.isEmpty() && mst.size() < vNum - 1) {
            Edge minEdge = pq.poll();
            if (!uf.isConnented(minEdge.getVerfrom(), minEdge.getVerto())) {//通过并查集判断是否连在一起，排除生成环
                mst.add(minEdge);
                uf.quickUnion(minEdge.getVerfrom(), minEdge.getVerto());
            }
        }
    }


    public List<Edge> getMst() {
        return mst;
    }

    public double getWeight() {
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
        Kruskal kruskal = new Kruskal(graph);
        double endTime = System.currentTimeMillis(); //获取结束时间


        List<Edge> mst = kruskal.getMst();
        System.out.println("Test Kruskal MST:");
        for (int i = 0; i < mst.size(); i++) {
            mst.get(i).show();
            System.out.println();
        }

        DecimalFormat df = new DecimalFormat("######0.00000");
        System.out.println("The MST weight is: " + df.format(kruskal.getWeight()));

        System.out.println("程序运行时间： " + (endTime - startTime) / 1000 + "s");


    }


}
