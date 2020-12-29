//反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。 
//
// 说明: 
//1 ≤ m ≤ n ≤ 链表长度。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL, m = 2, n = 4
//输出: 1->4->3->2->5->NULL 
// Related Topics 链表 
// 👍 607 👎 0

package leetCode.editor.cn;

import tools.ListNode;

class ReverseLinkedListIi{

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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m == 1){
            return reverseListN(head, n);
        }
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }

    ListNode nextHead = null;
    public ListNode reverseListN(ListNode head, int n){
        if(n==1){
            nextHead = head.next;
            return head;
        }
        ListNode last = reverseListN(head.next, n - 1);
        head.next.next = head;
        head.next = nextHead;
        return last;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
       Solution solution = new ReverseLinkedListIi().new Solution();
    }
}