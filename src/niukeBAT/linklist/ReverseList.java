package niukeBAT.linklist;
/**
 * 反转单链表
 */

import tools.LinkListNode;

public class ReverseList {
    public static void main(String[] args) {
        int[] array = {1, 3, 5, 3, 4, 5, 7, 2, 4, 6, 43, 25};
        LinkListNode head = LinkListNode.constructLinkList(array);
        LinkListNode.traverse(head);

        LinkListNode reverdList = reversedList(head);

        LinkListNode.traverse(reverdList);
    }

    private static LinkListNode reversedList(LinkListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        LinkListNode cur = head.next;//当前还没有反转的节点
        LinkListNode pre = null;//前一个节点
        LinkListNode temp;//下一个节点
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;

            pre = cur;
            cur = temp;
        }
        head.next = pre;
        return head;
    }
}
