package basicAlgorithm.unionFind;

/**
 * 并查集0
 * id值相同连在一起
 */
public class UnionFind0 {
    int[] id;
    int count;

    public UnionFind0(int n) {
        count = n;
        id = new int[n];
        for (int i = 0; i < count; i++) {
            id[i] = i;
        }
    }

    public static void main(String[] args) {
        int n = 100000;
        UnionFind0 UnionFind0 = new UnionFind0(n);
        long startTime = System.currentTimeMillis();    //获取开始时间
        for (int i = 0; i < n; i++) {
            int p = (int) (Math.random() * n);
            int q = (int) (Math.random() * n);
            UnionFind0.union(p, q);
        }
        long endTime = System.currentTimeMillis();    //获取开始时间

        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
    }

    int find(int p) throws ArrayIndexOutOfBoundsException {
        if (p < 0 || p > count) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return id[p];
    }

    boolean isConnected(int p, int q) {
        return find(q) == find(p);
    }

    void union(int p, int q) {
        int pID = find(p);
        int qID = find(q);

        if (pID == qID) return;

        for (int i = 0; i < count; i++) {
            if (id[i] == pID) id[i] = qID;
        }
    }
}
