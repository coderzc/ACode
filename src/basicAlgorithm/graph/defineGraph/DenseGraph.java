package basicAlgorithm.graph.defineGraph;

import java.util.ArrayList;
import java.util.List;

/**
 * 稠密图-邻接矩阵
 */

public class DenseGraph implements Graph {
    int vNum, eNum;
    boolean directed;
    Edge[][] g;


    public DenseGraph(int vNum) {
        this.vNum = vNum;
        this.eNum = 0;
        this.directed = false;
        g = new Edge[vNum][vNum];
    }

    public DenseGraph(int vNum, boolean directed) {
        this.vNum = vNum;
        this.eNum = 0;
        this.directed = directed;
        g = new Edge[vNum][vNum];
    }

    @Override
    public Graph createGraph(int vNum) {
        return new DenseGraph(vNum);
    }

    @Override
    public Graph createGraph(int vNum, boolean directed) {
        return new DenseGraph(vNum, directed);
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

        g[v][w] = new Edge(v, w);
        if (!directed) {
            g[w][v] = new Edge(w, v);
        }
        eNum++;
    }

    //添加边或更新权值
    @Override
    public void addEdge(int v, int w, double weight) {
        if (hasEdge(v, w)) {
            g[v][w].setWeight(weight);
            if (!directed) {
                g[w][v].setWeight(weight);
            }
        } else {
            g[v][w] = new Edge(v, w, weight);
            if (!directed) {
                g[w][v] = new Edge(w, v, weight);
            }
            eNum++;
        }
    }

    @Override
    public List<Integer> getAdjs(int v) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < g[v].length; i++) {
            if (hasEdge(v, i)) {
                list.add(i);
            }
        }
        return list;
    }

    @Override
    public List<Edge> getAdjEdges(int v) {
        List<Edge> list = new ArrayList<>();
        for (int i = 0; i < g[v].length; i++) {
            if (hasEdge(v, i)) {
                list.add(g[v][i]);
            }
        }
        return list;
    }

    @Override
    public boolean hasEdge(int v, int w) {
        if (v < 0 || v >= vNum) throw new ArrayIndexOutOfBoundsException();
        if (w < 0 || w >= vNum) throw new ArrayIndexOutOfBoundsException();
        return g[v][w] != null;
    }

    @Override
    public void show() {
        for (int i = 0; i < vNum; i++) {
            for (int j = 0; j < vNum; j++) {
                if (!hasEdge(i, j)) {
                    System.out.format("%4s\t", "∞");
                } else {
                    System.out.format("%4s\t", g[i][j].getWeight());
                }
            }
            System.out.println("");
        }
        System.out.println("");
    }
}
