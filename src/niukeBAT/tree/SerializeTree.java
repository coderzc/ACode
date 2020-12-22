package niukeBAT.tree;

import tools.Order;
import tools.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeTree {
    public static void main(String[] args) {
        int[] preOrder = {11, 2, 4, 7, 3, 5, 6, 8};
        int[] inOrder = {4, 7, 2, 11, 5, 3, 8, 6};
        TreeNode binaryTree = TreeNode.reConstruct(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);

        System.out.println(serializeTree(binaryTree));
        Order.levelOrder2(binaryTree);
    }


    public static String serializeTree(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if(poll!=null){
                stringBuilder.append(poll.val).append("!");
                queue.offer(poll.left);
                queue.offer(poll.right);
            }else {
                stringBuilder.append("#").append("!");
            }

        }

        return stringBuilder.toString();
    }
}
