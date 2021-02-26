//给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。 
//
// 说明： 
//你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。 
//
// 示例 1: 
//
// 输入: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//   2
//输出: 1 
//
// 示例 2: 
//
// 输入: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
//输出: 3 
//
// 进阶： 
//如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？ 
// Related Topics 树 二分查找 
// 👍 331 👎 0

package leetCode.editor.cn;

import java.util.ArrayList;
import java.util.List;

import tools.TreeNode;

class KthSmallestElementInABst{

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        kthSmallest(root, k, list);
        if(list.size() < (k-1)){
            return -1;
        }else {
            return list.get(k-1);
        }
    }

    public void kthSmallest(TreeNode root, int k, List<Integer> list) {
        if(root == null){
            return;
        }
        kthSmallest(root.left, k , list);
        if(list.size() >= k){
            return;
        } else {
            list.add(root.val);
        }
        kthSmallest(root.right, k, list);
    }
}
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
       Solution solution = new KthSmallestElementInABst().new Solution();
    }
}