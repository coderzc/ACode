package Tools;

import java.util.LinkedList;
import java.util.Queue;

public class Order {
    //先序遍历
    public static void preOrder(TreeNode tree){
        if(tree==null){
            return;
        }
        System.out.print(tree.data);
        preOrder(tree.leftNode);
        preOrder(tree.rightNode);
    }

    //中序遍历(二叉搜索树排序)
    public static void inOrder(TreeNode tree){
        if(tree==null){
            return;
        }
        inOrder(tree.leftNode);
        System.out.print(tree.data);
        inOrder(tree.rightNode);
    }

    //后序遍历
    public static void postOrder(TreeNode tree){
        if(tree==null){
            return;
        }
        preOrder(tree.leftNode);
        preOrder(tree.rightNode);
        System.out.print(tree.data);
    }

    //层序遍历
    public static void levelOrder(TreeNode tree){
        Queue<TreeNode> queue= new LinkedList<TreeNode>();
        queue.offer(tree);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            System.out.print(node.data);
            if(node.leftNode!=null){
                queue.offer(node.leftNode);
            }if(node.rightNode!=null){
                queue.offer(node.rightNode);
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
            System.out.print(node.data+"\t");
            if(current==0){
                System.out.println("第"+number+"行");
            }
            if(node.leftNode!=null){
                queue.offer(node.leftNode);
                next++;
            }if(node.rightNode!=null){
                queue.offer(node.rightNode);
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
