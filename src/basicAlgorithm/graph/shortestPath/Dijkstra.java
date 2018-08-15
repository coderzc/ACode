package basicAlgorithm.graph.shortestPath;

import basicAlgorithm.graph.defineGraph.Edge;
import basicAlgorithm.graph.defineGraph.Graph;
import basicAlgorithm.graph.defineGraph.SparseGraph;
import basicAlgorithm.heap.IndexPrirotyQueue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Stack;

/**
 * 解决不含负权边的单源最短路径问题 O(E*logV)
 */
public class Dijkstra {
    private Graph graph;
    private int s;

    private boolean[] marked;
    private Double[] dist;//到原点距离(总权值)
    private int[] path;

    public Dijkstra(Graph graph, int s) {
        this.graph = graph;
        this.s = s;

        marked = new boolean[graph.V()];
        dist = new Double[graph.V()];
        path = new int[graph.V()];

        for (int i = 0; i < graph.V(); i++) {
            path[i] = -1;//-1代表s->i无法到达
            marked[i] = false;
            dist[i] = null;//s->i无法到达
            if (i == 0) {
//                marked[s] = true;
//                path[s] = -1;//s->s path 特殊标记
                dist[i] = 0.0;
            }
        }

        IndexPrirotyQueue<Double> ipq = new IndexPrirotyQueue<>(graph.V());

        //Dijkstra
        ipq.offer(s, dist[s]);

        while (!ipq.isEmpty()) {
            int v = ipq.pollIndex();//获取最小边的的索引值并出队(其实就是邻接点)
            marked[v] = true;//v节点已经找到了最短路径，标记上

            List<Edge> adjEdges = graph.getAdjEdges(v);
            for (int i = 0; i < adjEdges.size(); i++) {
                Edge edge = adjEdges.get(i);
                int w = edge.getVerto();//获取邻接点
                if (!marked[w]) {

                    if (path[w] == -1 || dist[v] + edge.getWeight() < dist[w]) {//没有访问过或者出现了更短的路径
                        dist[w] = dist[v] + edge.getWeight();
                        path[w] = edge.getVerfrom();
                        if (ipq.contains(w)) {
                            ipq.change(w, dist[w]);
                        } else {
                            ipq.offer(w, dist[w]);
                        }
                    }

                }
            }
        }

    }

    public Double getShortestDistTo(int w) {
        return dist[w];
    }

    public boolean hasPathTo(int w) {
        return marked[w];
    }

    //显示从s->v的路径
    public void showPath(int v) {
        Stack<Integer> stack = new Stack<>();

        while (v != -1) {
            stack.push(v);
            v = path[v];
        }

        System.out.print("Path:");
        while (!stack.empty()) {
            if (stack.size() == 1) {
                System.out.println(stack.pop());
            } else {
                System.out.print(stack.pop() + "->");
            }
        }
    }


    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("src/graph/shortestPath/sp.txt"));

        int vNum = Integer.parseInt(lines.get(0).split(" ")[0]);
        int eNum = Integer.parseInt(lines.get(0).split(" ")[1]);

        Graph graph = new SparseGraph(vNum, false);

        for (int i = 1; i < lines.size(); i++) {
            String[] strs = lines.get(i).split(" ");
            graph.addEdge(Integer.valueOf(strs[0]), Integer.valueOf(strs[1]), Double.valueOf(strs[2]));
        }

        double startTime = System.currentTimeMillis();   //获取开始时间
        Dijkstra dijkstra = new Dijkstra(graph, 0);
        double endTime = System.currentTimeMillis(); //获取结束时间


        for (int i = 1; i < graph.V(); i++) {
            double dist = dijkstra.getShortestDistTo(i);
            System.out.println("dist to " + i + ": " + dist);
            dijkstra.showPath(i);
            System.out.println("-------------");
        }

        System.out.println("程序运行时间： " + (endTime - startTime) / 1000 + "s");


    }
}
