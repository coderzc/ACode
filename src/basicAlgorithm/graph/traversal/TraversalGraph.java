package basicAlgorithm.graph.traversal;

import graph.defineGraph.DenseGraph;
import graph.defineGraph.Graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 图的遍历
 */
public class TraversalGraph {
    private Graph g;
    private boolean[] visited;//点是否遍历过了
    private int ccount;//连通分量数

    private int[] dist;//最短距离
    private int[] path;//上一步节点


    public TraversalGraph(Graph g) {
        this.g = g;
        this.visited = new boolean[g.V()];
        this.dist = new int[g.V()];
        this.path = new int[g.V()];


        for (int i = 0; i < g.V(); i++) {
            visited[i] = false;
            dist[i] = -1;
            path[i] = -1;
        }

    }

    //求连通分量数量并且遍历(DFS)
    public int componentDFS() {
        ccount = 0;

        for (int i = 0; i < g.V(); i++) {
            if (!visited[i]) {
                dfs(i);//从i节点开始 访问此连通分量
                System.out.println("");//此连通分量访问完毕
                ccount++;//连通分量+1
            }
        }

        return ccount;

    }

    //求连通分量数量并且遍历(BFS)
    public int componentBFS() {
        ccount = 0;

        for (int i = 0; i < g.V(); i++) {
            if (!visited[i]) {
                bfs(i);//从i节点开始 访问此连通分量
                System.out.println("");//此连通分量访问完毕
                ccount++;//连通分量+1
            }
        }

        return ccount;

    }

    //无权图的最短路径
    public void shortestPathBFS(int s) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(s);
        visited[s] = true;
        dist[s] = 0;

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            System.out.print(poll + "\t");

            List<Integer> adjvex = g.getAdjs(poll);//获取邻接点
            for (Integer i : adjvex) {
                if (!visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                    path[i] = poll;
                    dist[i] = dist[poll] + 1;
                }

            }
        }

        System.out.println();
    }

    public void dfs(int v) {
        System.out.print(v + "\t");//访问节点
        visited[v] = true;//已经访问了

        List<Integer> adjvex = g.getAdjs(v);//获取邻接点
        for (Integer i : adjvex) {
            if (!visited[i]) dfs(i);
        }
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

    public void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(v);
        visited[v] = true;

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            System.out.print(poll + "\t");

            List<Integer> adjvex = g.getAdjs(poll);//获取邻接点
            for (Integer i : adjvex) {
                if (!visited[i]) queue.offer(i);
                visited[i] = true;
            }
        }

    }

    public static void main(String[] args) {
        Graph graph = new DenseGraph(7, false);
        int[][] a2 = {{0, 2}, {0, 1}, {0, 5}, {0, 6}, {4, 6}, {4, 5}, {4, 3}, {5, 3}};
        for (int[] ints : a2) {
            graph.addEdge(ints[0], ints[1]);
        }

        graph.show();

        TraversalGraph traversalGraph = new TraversalGraph(graph);

        int ccount = traversalGraph.componentDFS();
//        int ccount = traversalGraph.componentBFS();
        System.out.println("连通分量数:" + ccount);


//        traversalGraph.shortestPathBFS(0);
//        traversalGraph.showPath(4);
    }
}
