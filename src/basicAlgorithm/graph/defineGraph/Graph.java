package basicAlgorithm.graph.defineGraph;

import java.util.List;

public interface Graph {
    Graph createGraph(int vNum);//无向图

    Graph createGraph(int vNum, boolean directed);

    int V();//图中顶点数

    int E();//图中边数

    void addEdge(int v, int w);//无权图

    void addEdge(int v, int w, double weight);

    List<Integer> getAdjs(int v);//返回所有的邻接点

    List<Edge> getAdjEdges(int v);//返回邻接边

    boolean hasEdge(int v, int w);//v到w是否有边

    void show();
}
