package tools;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
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
        bt.left = reConstruct(preOrder, startpre + 1, startpre + leftNum, inOrder, startIn, i - 1);
        bt.right = reConstruct(preOrder, endpre - rightNum + 1, endpre, inOrder, i + 1, endIn);
        return bt;
    }
}