package basicAlgorithm.graph.mst;

import basicAlgorithm.graph.defineGraph.Edge;
import basicAlgorithm.graph.defineGraph.Graph;
import basicAlgorithm.graph.defineGraph.SparseGraph;
import basicAlgorithm.heap.IndexPrirotyQueue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * O(E*logV)
 */
public class Prim {

    private Graph graph;
    private IndexPrirotyQueue<Edge> pq;//待选边
    private boolean[] marked;//节点是否已经加入树中
    private List<Edge> mst;//最小生成树的所有边的集合
    private double weight;//最小生成树的总权值

    public Prim(Graph graph) {
        this.graph = graph;
        pq = new IndexPrirotyQueue<Edge>(graph.V());
        marked = new boolean[graph.V()];
        mst = new ArrayList<>(graph.V() - 1);

        mst();

    }

    private void visit(int v) {
        marked[v] = true;
        for (Edge edge : graph.getAdjEdges(v)) {
            int i = edge.getVerto();
            if (!marked[i]) {
                if (!pq.contains(i)) {
                    pq.offer(i, edge);
                } else {
                    if (edge.getWeight() < pq.getItem(i).getWeight()) {
                        pq.change(i, edge);
                    }
                }
            }
        }
    }

    private void mst() {
        visit(0);
        while (!pq.isEmpty()) {
            Edge minEdge = pq.poll();
//          if (marked[minEdge.getVerfrom()] == marked[minEdge.getVerto()]) continue; 因为每个邻接点只保留目前最短的边所以不用判断
            mst.add(minEdge);
            visit(minEdge.getVerto());
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
        Prim prim = new Prim(graph);
        double endTime = System.currentTimeMillis(); //获取结束时间


        List<Edge> mst = prim.getMst();
        System.out.println("Test Prim MST:");
        for (int i = 0; i < mst.size(); i++) {
            mst.get(i).show();
            System.out.println();
        }

        DecimalFormat df = new DecimalFormat("######0.00000");
        System.out.println("The MST weight is: " + df.format(prim.getWeight()));

        System.out.println("程序运行时间： " + (endTime - startTime) / 1000 + "s");


    }

}
