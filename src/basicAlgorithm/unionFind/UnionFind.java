package basicAlgorithm.unionFind;

/**
 * 并查集
 * p与q连在一起则，parent[p]=q;
 */
public class UnionFind {
    int[] parent;
    int[] sz;//以sz[i]为根的集合中元素个数
    int[] rank;//以rank[i]为根的集合中元素高度
    int count;

    public UnionFind(int n) {
        count = n;
        parent = new int[n];
        sz = new int[n];
        rank = new int[n];
        for (int i = 0; i < count; i++) {
            parent[i] = i;
            sz[i] = 1;
            rank[i] = 1;
        }
    }


    public int find(int p) {//找根节点
        if (p < 0 || p > count) {
            throw new ArrayIndexOutOfBoundsException();
        }
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }

    public int find2(int p) {//找根节点(路径压缩)
        if (p < 0 || p > count) {
            throw new ArrayIndexOutOfBoundsException();
        }
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];//重点 p的父节点变成爷爷节点
            p = parent[p];
        }
        return p;
    }

    public int find3(int p) {//找根节点(路径压缩 高压版 每个集合最多只有两层)
        if (p < 0 || p > count) {
            throw new ArrayIndexOutOfBoundsException();
        }

        if (p == parent[p]) return p;

        parent[p] = find3(parent[p]);
        return parent[p];
    }

    public boolean isConnented(int p, int q) {//p和q是否可以连通
        return find2(p) == find2(q);
    }

    //普通版
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot)
            return;

        parent[pRoot] = qRoot;
    }

    //把小的集合加入大的集合，合并后的集合高度更小
    public void quickUnion1(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot)
            return;

        if (sz[pRoot] < sz[qRoot]) {
            parent[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        } else {
            parent[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }
    }

    //用树的高度来代替树的节点个数进行小大判断
    public void quickUnion2(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot)
            return;

        if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        } else if (rank[pRoot] > rank[qRoot]) {
            parent[qRoot] = pRoot;
        } else {
            parent[pRoot] = qRoot;
            rank[qRoot] += 1;
        }
    }

    //路径压缩(find2)
    public void quickUnion(int p, int q) {
        int pRoot = find2(p);
        int qRoot = find2(q);

        if (pRoot == qRoot)
            return;

        if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        } else if (rank[pRoot] > rank[qRoot]) {
            parent[qRoot] = pRoot;
        } else {
            parent[pRoot] = qRoot;
            rank[qRoot] += 1;
        }
    }

    //路径高压版(find3)
    public void quickUnion4(int p, int q) {
        int pRoot = find3(p);
        int qRoot = find3(q);

        if (pRoot == qRoot)
            return;

        if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        } else if (rank[pRoot] > rank[qRoot]) {
            parent[qRoot] = pRoot;
        } else {
            parent[pRoot] = qRoot;
            rank[qRoot] += 1;
        }
    }


    public static void main(String[] args) {
        int n = 1000000;
        UnionFind unionFind = new UnionFind(n);
        long startTime = System.currentTimeMillis();    //获取开始时间
        for (int i = 0; i < n; i++) {
            int p = (int) (Math.random() * n);
            int q = (int) (Math.random() * n);
//            unionFind.union(p, q);
//            unionFind.quickUnion1(p, q);
//            unionFind.quickUnion2(p, q);
//            unionFind.quickUnion3(p, q);
            unionFind.quickUnion4(p, q);
        }
        long endTime = System.currentTimeMillis();    //获取开始时间

        double runtime = (endTime - startTime);

        System.out.println("程序运行时间：" + runtime / 1000 + "s");
    }
}
