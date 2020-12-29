//反转一个单链表。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表 
// 👍 1409 👎 0

package leetCode.editor.cn;

import tools.ListNode;

class ReverseLinkedList{

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    /**
     * 迭代写法
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        ListNode next;
        while (cur!=null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 递归写法
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
       Solution solution = new ReverseLinkedList().new Solution();
    }
}