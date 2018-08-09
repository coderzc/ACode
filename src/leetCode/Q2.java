package leetCode;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Q2 {

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

    public static void main(String[] args) {
        Q2 q2 = new Q2();
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

        ListNode listNode = q2.addTwoNumbers(l1, l2);

        while (listNode!=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
    }
}



