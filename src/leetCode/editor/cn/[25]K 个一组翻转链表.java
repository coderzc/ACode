//给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。 
//
// 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 
//
// 示例： 
//
// 给你这个链表：1->2->3->4->5 
//
// 当 k = 2 时，应当返回: 2->1->4->3->5 
//
// 当 k = 3 时，应当返回: 3->2->1->4->5 
//
// 
//
// 说明： 
//
// 
// 你的算法只能使用常数的额外空间。 
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
// 
// Related Topics 链表 
// 👍 825 👎 0

package leetCode.editor.cn;

import tools.ListNode;

class ReverseNodesInKGroup {

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            return reverseKGroup(head, head, k, k);
        }

        public ListNode reverseKGroup(ListNode cur,ListNode head, int n, int k) {
            if(cur == null){
                return head;
            }
            if(n==1) {
                ListNode next = cur.next;
                cur.next = null;
                ListNode newHead = reverse(head);
                head.next = reverseKGroup(next, next, k,k);
                return newHead;
            } else {
                return reverseKGroup(head.next, head,n-1, k);
            }

        }

        public ListNode reverse(ListNode head) {
            ListNode cur = head;
            ListNode pre = null;
            ListNode next = null;
            while (cur != null) {
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new ReverseNodesInKGroup().new Solution();
    }
}