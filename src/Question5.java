/**
 * 反向输出单链表
 */

import java.util.LinkedList;
import java.util.Stack;

class ListNode {
    int data;
    ListNode next;

    public ListNode() {
        this.next = null;
    }

    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Question5 {

    public static ListNode insert(ListNode listNode,int x){
        ListNode last=listNode;
        if (listNode == null) {
            listNode = new ListNode(x);
        } else {
            while (last.next!=null){
                last=last.next;
            }
            ListNode newNode=new ListNode(x);
            last.next=newNode;
        }
        return listNode;
    }

    public static void printListFromTailTOHead(ListNode list) {
        Stack<ListNode> stack = new Stack();

        while (list != null) {
            stack.push(list);
            list = list.next;
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop().data);
        }
    }

    public static void main(String[] args) {
        ListNode listNode = null;

        int[] array = {1, 2, 3, 4, 5};
        for (int x : array) {
            listNode=insert(listNode,x);
        }

        printListFromTailTOHead(listNode);
    }

}
