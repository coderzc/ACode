package tools;

public class TreeNode {
    public int data;
    public TreeNode leftNode;
    public TreeNode rightNode;

    public TreeNode(int data) {
        this.data = data;
        this.leftNode = null;
        this.rightNode = null;
    }


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
}