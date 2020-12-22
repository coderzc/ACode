package tools;

import java.util.LinkedList;
import java.util.Queue;

public class Order {
    //先序遍历
    public static void preOrder(TreeNode tree){
        if(tree==null){
            return;
        }
        System.out.print(tree.val);
        preOrder(tree.left);
        preOrder(tree.right);
    }

    //中序遍历(二叉搜索树排序)
    public static void inOrder(TreeNode tree){
        if(tree==null){
            return;
        }
        inOrder(tree.left);
        System.out.print(tree.val);
        inOrder(tree.right);
    }

    //后序遍历
    public static void postOrder(TreeNode tree){
        if(tree==null){
            return;
        }
        preOrder(tree.left);
        preOrder(tree.right);
        System.out.print(tree.val);
    }

    //层序遍历
    public static void levelOrder(TreeNode tree){
        Queue<TreeNode> queue= new LinkedList<TreeNode>();
        queue.offer(tree);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            System.out.print(node.val);
            if(node.left !=null){
                queue.offer(node.left);
            }if(node.right !=null){
                queue.offer(node.right);
            }
        }
    }

    //层序遍历(分层带编号）
    public static void levelOrder2(TreeNode tree){
        Queue<TreeNode> queue= new LinkedList<TreeNode>();
        queue.offer(tree);

        int current=1;//当前层 还未打印的结点个数
        int next=0;//下一层结点个数
        int number=1;//行号

        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            current--;
            System.out.print(node.val +"\t");
            if(current==0){
                System.out.println("第"+number+"行");
            }
            if(node.left !=null){
                queue.offer(node.left);
                next++;
            }if(node.right !=null){
                queue.offer(node.right);
                next++;
            }
            if(current==0){
                current=next;
                next=0;
                number++;
            }
        }
    }
}
