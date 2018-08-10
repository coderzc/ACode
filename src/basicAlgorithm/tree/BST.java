package basicAlgorithm.tree;

/**
 * 二叉搜索树
 */

class TreeNode {
    int key;
    Object value;
    TreeNode leftNode;
    TreeNode rightNode;

    public TreeNode(int key, Object value) {
        this.key = key;
        this.value = value;
        this.leftNode = this.rightNode = null;
    }
}

public class BST {

    //递归插入
    public static TreeNode insert(TreeNode tree, int key, Object value) {
        if (tree == null) {
            tree = new TreeNode(key, value);
        }

        if (key == tree.key) {
            tree.value = value;
        } else if (key > tree.key) {
            tree.rightNode = insert(tree.rightNode, key, value);
        } else {
            tree.leftNode = insert(tree.leftNode, key, value);
        }

        return tree;
    }

    //是否存在key
    public static Boolean contains(TreeNode tree, int key) {
        if (tree == null) {
            return false;
        }
        if (key == tree.key) {
            return true;
        } else if (key > tree.key) {
            return contains(tree.rightNode, key);
        } else {
            return contains(tree.leftNode, key);
        }
    }

    //由key搜索value
    public static Object search(TreeNode tree, int key) {
        if (tree == null) {
            return null;
        }
        if (key == tree.key) {
            return tree.value;
        } else if (key > tree.key) {
            return search(tree.rightNode, key);
        } else {
            return search(tree.leftNode, key);
        }
    }

    //找最小值
    public static TreeNode minimum(TreeNode tree) {
        while (tree.leftNode != null) {
            tree = tree.leftNode;
        }
        return tree;
    }

    //找最大值
    public static TreeNode maximum(TreeNode tree) {
        while (tree.rightNode != null) {
            tree = tree.rightNode;
        }
        return tree;
    }

    //删除最小节点
    public static TreeNode removeMin(TreeNode tree) {
        if (tree == null) {
            return null;
        }
        if (tree.leftNode == null) {
            tree = tree.rightNode;
        } else {
            tree.leftNode = removeMin(tree.leftNode);
        }
        return tree;
    }

    //删除最大节点
    public static TreeNode removeMax(TreeNode tree) {
        if (tree == null) {
            return null;
        }
        if (tree.rightNode == null) {
            tree = tree.leftNode;
        } else {
            tree.rightNode = removeMax(tree.rightNode);
        }
        return tree;
    }

    //删除
    public static TreeNode remove(TreeNode tree, int key) {
        if (tree == null) {
            return null;
        }
        if (key > tree.key) {
            tree.rightNode = remove(tree.rightNode, key);
        } else if (key < tree.key) {
            tree.leftNode = remove(tree.leftNode, key);
        } else {
            if (tree.leftNode == null) {
                tree = tree.rightNode;
            } else if (tree.rightNode == null) {
                tree = tree.leftNode;
            } else {
                TreeNode successor = minimum(tree.rightNode);
                successor.rightNode = removeMin(tree.rightNode);
                successor.leftNode = tree.leftNode;
                tree = successor;
            }
        }

        return tree;
    }


    public static void main(String[] args) {
//        TreeNode root = null;
//        char[] array = {'a', 'a', 'd', 'h', 'h', 'w', 'h', 'h'};
//        for (char x : array) {
//            Integer freq = (Integer) search(root, x);
//            if (freq == null) {
//                root = insert(root, x, 1);
//            } else {
//                root = insert(root, x, ++freq);
//            }
//        }
//
//        System.out.println(search(root, 'h'));

        TreeNode root = null;
        int[] arr = {8, 3, 10, 1, 6, 14, 4, 7, 13};
        for (int x : arr) {
            root = BST.insert(root, x, "x:" + x);
        }

        BTOrder.levelOrder2(root);
        System.out.println("\n");
        remove(root, 3);
        BTOrder.levelOrder2(root);
    }
}
