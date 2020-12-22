package leetCode;

public class Q92 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return null;
        int index = 1;
        ListNode l1 = head;
        while (index != m) {
            l1 = l1.next;
        }
        ListNode l2 = l1;
        while (index != n) {
            l2 = l2.next;
        }

        ListNode pre = l2.next;
        ListNode cur = l1;
        while (cur != l2.next) {
            ListNode temp = l1.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }

        return head;
    }
}
