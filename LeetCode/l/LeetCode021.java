package l;

import util.ListNode;

public class LeetCode021 {
    //Merge two sorted linked lists and return it as a sorted list. The list should
//be made by splicing together the nodes of the first two lists.
//
//
// Example 1:
//
//
//Input: l1 = [1,2,4], l2 = [1,3,4]
//Output: [1,1,2,3,4,4]
//
//
// Example 2:
//
//
//Input: l1 = [], l2 = []
//Output: []
//
//
// Example 3:
//
//
//Input: l1 = [], l2 = [0]
//Output: [0]
//
//
//
// Constraints:
//
//
// The number of nodes in both lists is in the range [0, 50].
// -100 <= Node.val <= 100
// Both l1 and l2 are sorted in non-decreasing order.
//
// Related Topics Linked List Recursion

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode curL1 = l1;
        ListNode curL2 = l2;
        ListNode cur= new ListNode(0);
        ListNode head = cur;
        while(curL1 != null || curL2 != null){
            if(curL1 == null){
                cur.next= curL2;
                break;
            }else if(curL2 == null){
                cur.next = curL1;
                break;
            }else {
                if(curL1.val < curL2.val){
                    cur.next = curL1;
                    curL1 = curL1.next;
                    cur = cur.next;
                }else {
                    cur.next = curL2;
                    curL2 = curL2.next;
                    cur = cur.next;
                }
            }
        }
        return head.next;
    }

    public static void main(String[] args) {
        System.out.println("keep happy");
        ListNode head = new ListNode(1);
        head.next=new ListNode(3);
        head.next.next=new ListNode(5);
        head.next.next.next=new ListNode(7);
        head.next.next.next.next=new ListNode(9);

        ListNode head1 = new ListNode(2);
        head1.next=new ListNode(4);
//        head1.next.next=new ListNode(3);
//        head1.next.next.next=new ListNode(4);
//        head1.next.next.next.next=new ListNode(5);

        System.out.println(mergeTwoLists(head,head1));
    }

}
