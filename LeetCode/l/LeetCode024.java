package l;

import util.ListNode;

public class LeetCode024 {

    public static  ListNode swapPairs_2(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode tmp = new ListNode(0);
        tmp.next = head;
        ListNode pre = tmp;
        ListNode after = head.next;
        while(head != null && head.next != null){
            head.next=after.next;
            after.next=head;
            pre.next=after;
            pre = pre.next.next;
            if(pre != null && pre.next != null){
                head = pre.next;
            }
            if(head != null && head.next != null){
                after=head.next;
            }
        }

        return tmp.next;
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        return swapPairs(head,head.next);
    }

    private static ListNode swapPairs(ListNode head, ListNode next) {
        head.next = next.next;
        next.next=head;
        if(head.next != null && head.next.next != null){
            head.next = swapPairs(head.next, head.next.next);
        }
        return next;
    }

    public static void main(String[] args) {

        ListNode h1 = new ListNode(1);
        h1.next = new ListNode(2);
        h1.next.next = new ListNode(3);
        h1.next.next.next = new ListNode(4);
        h1.next.next.next.next= new ListNode(5);
        h1.next.next.next.next.next = new ListNode(6);

        System.out.println(swapPairs(h1));


    }
}
