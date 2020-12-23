//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学 
// 👍 5413 👎 0

package leetCode.editor.cn;


import tools.ListNode;

class AddTwoNumbers{

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre=new ListNode(0);
        ListNode head=pre;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val;
            int a = -1; //进位
            if (sum >= 10) {
                a = 1;
                pre.next=new ListNode(sum % 10);
                pre=pre.next;
            } else {
                pre.next=new ListNode(sum);
                pre=pre.next;
            }
            l1 = l1.next;
            l2 = l2.next;

            if(a==-1) continue;

            if (l2 == null & l1 == null) {
                pre.next=new ListNode(a);
                pre=pre.next;
            } else if (l2 == null && l1 != null) {
                l1.val += a;
            } else {
                l2.val += a;
            }
        }

        if (l1 == null && l2 != null) {
            while (l2 != null) {
                if(l2.val>=10){
                    int a=l2.val%10;
                    l2.val=a;
                    if(l2.next!=null){
                        l2.next.val+=1;
                    }else {
                        l2.next=new ListNode(1);
                    }
                }
                pre.next=new ListNode(l2.val);
                pre=pre.next;
                l2 = l2.next;
            }
        }

        if (l1 != null && l2 == null) {
            while (l1 != null) {
                if(l1.val>=10){
                    int a=l1.val%10;
                    l1.val=a;
                    if(l1.next!=null){
                        l1.next.val+=1;
                    }else {
                        l1.next=new ListNode(1);
                    }
                }
                pre.next=new ListNode(l1.val);
                pre=pre.next;
                l1 = l1.next;
            }
        }

        return head.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
       Solution solution = new AddTwoNumbers().new Solution();
        ListNode l1 = new ListNode(1);
        //        ListNode l12 = new ListNode(4);
        //        ListNode l13 = new ListNode(3);
        //        l12.next = l13;
        //        l1.next = l12;

        ListNode l2 = new ListNode(9);
        ListNode l22 = new ListNode(9);
        //        ListNode l23 = new ListNode(4);
        //        l22.next = l23;
        l2.next = l22;

        ListNode listNode = solution.addTwoNumbers(l1, l2);

        while (listNode!=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
    }
}