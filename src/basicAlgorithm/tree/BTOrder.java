package basicAlgorithm.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树遍历
 */
public class BTOrder {
    //先序遍历
    public static void preOrder(TreeNode tree) {
        if (tree == null) {
            return;
        }
        System.out.print(tree.key);
        preOrder(tree.leftNode);
        preOrder(tree.rightNode);
    }

    //中序遍历(二叉搜索树排序)
    public static void inOrder(TreeNode tree) {
        if (tree == null) {
            return;
        }
        inOrder(tree.leftNode);
        System.out.print(tree.key);
        inOrder(tree.rightNode);
    }

    //中序遍历(非递归)
    public static void inOrder2(TreeNode tree) {
        if (tree == null) return;
        Stack<TreeNode> stack = new Stack<>();
        while (tree != null || !stack.isEmpty()) {
            while (tree != null) {//当前节点不为null则入栈
                stack.push(tree);
                tree = tree.leftNode;
            }
            TreeNode node = stack.pop();//当前节点为null则出栈
            System.out.print(node.key);
            tree = node.rightNode;//指向节点的右孩子，继续循环

        }
    }

    //后序遍历
    public static void postOrder(TreeNode tree) {
        if (tree == null) {
            return;
        }
        preOrder(tree.leftNode);
        preOrder(tree.rightNode);
        System.out.print(tree.key);
    }

    //层序遍历
    public static void levelOrder(TreeNode tree) {
        if (tree == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(tree);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.key);
            if (node.leftNode != null) {
                queue.offer(node.leftNode);
            }
            if (node.rightNode != null) {
                queue.offer(node.rightNode);
            }
        }
    }

    //层序遍历(分层带编号）
    public static void levelOrder2(TreeNode tree) {
        if (tree == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(tree);

        int current = 1;//当前层 还未打印的结点个数
        int next = 0;//下一层结点个数
        int number = 1;//行号

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            current--;
            System.out.print(node.key + "\t");
            if (current == 0) {
                System.out.println("第" + number + "行");
            }
            if (node.leftNode != null) {
                queue.offer(node.leftNode);
                next++;
            }
            if (node.rightNode != null) {
                queue.offer(node.rightNode);
                next++;
            }
            if (current == 0) {
                current = next;
                next = 0;
                number++;
                System.out.println("\n");

            }
        }
    }


    public static void main(String[] args) {
        int[] array = {10, 6, 14, 4, 16};
        TreeNode root = null;
        for (int x : array) {
            root = BST.insert(root, x, "x:" + x);
        }

        preOrder(root);
        System.out.println("\n--------");
        inOrder(root);
        System.out.println("\n--------");
        inOrder2(root);
        System.out.println("\n--------");
        postOrder(root);
        System.out.println("\n--------");
        levelOrder(root);
        System.out.println("\n--------");
        levelOrder2(root);
    }
}
