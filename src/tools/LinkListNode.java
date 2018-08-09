package tools;

public class LinkListNode {
    public int data;
    public LinkListNode next;

    public LinkListNode(int data) {
        this.data = data;
        this.next = null;
    }

    public static void traverse(LinkListNode list) {
        if (list == null) {
            return;
        }
        list = list.next;
        while (list != null) {
            System.out.print(list.data + "\t");
            list = list.next;
        }
        System.out.println();
    }

    public static LinkListNode constructLinkList(int[] array) {
        LinkListNode head = new LinkListNode(-1);
        LinkListNode cur = head;
        for (int i : array) {
            cur.next = new LinkListNode(i);
            cur = cur.next;
        }

        return head;
    }
}
