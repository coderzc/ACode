package basicAlgorithm.graph.defineGraph;

import java.util.ArrayList;
import java.util.List;

public class SparseGraph implements Graph {
    private int vNum, eNum;
    private boolean directed;
    private List<List<Edge>> g;//与所有连接点所构成边的集合

    public SparseGraph(int vNum) {
        this.vNum = vNum;
        this.eNum = 0;
        this.directed = false;
        g = new ArrayList<>();
        for (int i = 0; i < vNum; i++) {
            g.add(new ArrayList<Edge>());
        }
    }

    public SparseGraph(int vNum, boolean directed) {
        this.vNum = vNum;
        this.eNum = 0;
        this.directed = directed;
        g = new ArrayList<>();
        for (int i = 0; i < vNum; i++) {
            g.add(new ArrayList<Edge>());
        }
    }

    @Override
    public Graph createGraph(int vNum) {
        return new SparseGraph(vNum);
    }

    @Override
    public Graph createGraph(int vNum, boolean directed) {
        return new SparseGraph(vNum, directed);
    }

    @Override
    public int V() {
        return vNum;
    }

    @Override
    public int E() {
        return eNum;
    }

    @Override
    public void addEdge(int v, int w) {
        if (hasEdge(v, w)) return;
        g.get(v).add(new Edge(v, w));
        if (v != w && !directed) {//处理了自环边
            g.get(w).add(new Edge(w, v));
        }
        eNum++;
    }

    @Override
    public void addEdge(int v, int w, double weight) {
        if (hasEdge(v, w)) return;
        g.get(v).add(new Edge(v, w, weight));
        if (v != w && !directed) {//处理了自环边
            g.get(w).add(new Edge(w, v, weight));
        }
        eNum++;

    }

    @Override
    public boolean hasEdge(int v, int w) {
        if (v < 0 || v >= vNum) throw new ArrayIndexOutOfBoundsException();
        if (w < 0 || w >= vNum) throw new ArrayIndexOutOfBoundsException();
        for (Edge e : g.get(v)) {
            if (e.getVerto() == w) return true;
        }
        return false;
    }

    @Override
    public List<Integer> getAdjs(int v) {
        List<Integer> list = new ArrayList<>();
        List<Edge> edges = g.get(v);
        for (Edge edge : edges) {
            list.add(edge.getVerto());
        }
        return list;
    }

    @Override
    public List<Edge> getAdjEdges(int v) {
        return g.get(v);
    }

    @Override
    public void show() {
        for (int i = 0; i < vNum; i++) {
            List<Integer> adjvex = getAdjs(i);
            List<Edge> edges = g.get(i);
            System.out.print(i + ":\t");
            for (Edge edge : edges) {
                edge.show();
                System.out.print("\t");
            }
            System.out.println();
        }
        System.out.println();
    }


}
