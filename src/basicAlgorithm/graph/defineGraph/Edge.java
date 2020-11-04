package basicAlgorithm.graph.defineGraph;

/**
 * 边模型
 */

public class Edge implements Comparable<Edge> {
    public int verto;//邻接点，边的终点
    public double weight;//权重
    public int verfrom;//起始点

    public Edge(int verfrom, int verto) {//无权图
        this.verto = verto;
        this.weight = 1;
        this.verfrom = verfrom;
    }

    public Edge(int verfrom, int verto, double weight) {
        this.verto = verto;
        this.weight = weight;
        this.verfrom = verfrom;
    }

    public int getVerto() {
        return verto;
    }

    public void setVerto(int verto) {
        this.verto = verto;
    }

    public int getVerfrom() {
        return verfrom;
    }

    public void setVerfrom(int verfrom) {
        this.verfrom = verfrom;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void show() {
        System.out.print(verfrom + "->" + verto + " " + weight + "\t");
    }

    @Override
    public int compareTo(Edge o) {
        if (this.weight > o.weight) {
            return 1;
        } else if (this.weight < o.weight) {
            return -1;
        } else {
            return 0;
        }
    }
}
