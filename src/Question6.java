import Tools.Order;
import Tools.TreeNode;

/**
 * 重建二叉树(已知先序和中序）
 */

public class Question6 {

    public static TreeNode reConstruct(int[] preOrder, int startpre, int endpre, int[] inOrder, int startIn, int endIn) {
        if (startpre > endpre || startIn > endIn) {
            return null;
        }

        int rootValue = preOrder[startpre];//根结点
        TreeNode bt = new TreeNode(rootValue);

        int i = startIn;
        for (; i<=endIn; i++) {
            if (inOrder[i] == rootValue) break;
        }
        int leftNum = i - startIn;//左子树节点数
        int rightNum = endIn - i;//右子树节点数
        bt.leftNode = reConstruct(preOrder, startpre + 1, startpre + leftNum, inOrder, startIn, i - 1);
        bt.rightNode = reConstruct(preOrder, endpre - rightNum + 1, endpre, inOrder, i + 1, endIn);
        return bt;
    }

    public static void main(String[] args) {

        int[] preOrder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inOrder = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode binaryTree = reConstruct(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);

        Order.levelOrder2(binaryTree);

    }

}
