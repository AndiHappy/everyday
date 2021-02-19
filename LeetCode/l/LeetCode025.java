package l;

import util.ListNode;

public class LeetCode025 {

//Given a linked list, reverse the nodes of a linked list k at a time and return
// its modified list.
//
// k is a positive integer and is less than or equal to the length of the linked
// list. If the number of nodes is not a multiple of k then left-out nodes, in the
// end, should remain as it is.
//
// Follow up:
//
//
// Could you solve the problem in O(1) extra memory space?
// You may not alter the values in the list's nodes, only nodes itself may be changed.
//
//
//
// Example 1:
//
//
//Input: head = [1,2,3,4,5], k = 2
//Output: [2,1,4,3,5]
//
//
// Example 2:
//
//
//Input: head = [1,2,3,4,5], k = 3
//Output: [3,2,1,4,5]
//
//
// Example 3:
//
//
//Input: head = [1,2,3,4,5], k = 1
//Output: [1,2,3,4,5]
//
//
// Example 4:
//
//
//Input: head = [1], k = 1
//Output: [1]
//
//
//
// Constraints:
//
//
// The number of nodes in the list is in the range sz.
// 1 <= sz <= 5000
// 0 <= Node.val <= 1000
// 1 <= k <= sz

    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1) return head;
        ListNode cur = head;
        ListNode kcur = head;
        int ktmp = k;
        while(kcur != null && ktmp > 1){
            kcur = kcur.next;
            ktmp--;
        }
        return reverseKGroup(cur,kcur,k);
    }

    public static ListNode reverseKGroup(ListNode head, ListNode kcur,int k) {
        if(kcur == null){
            return head;
        }else {
            // change
            // 0==>1==>2==>3==>4
            // 1==>2==>3==>0==>4
            // 2==>3==>1==>0==>4
            // 3==>2==>1==>0==>4
            ListNode headStore = head;

            ListNode headtmp = head;
            while(headtmp != kcur){
                headtmp = head.next;
                head.next=kcur.next;
                kcur.next=head;
                head = headtmp;
            }

            int ktmp = k;
            ListNode kcurAnother = headStore.next;
            while(kcurAnother != null && ktmp > 1){
                kcurAnother = kcurAnother.next;
                ktmp--;
            }

            headStore.next=reverseKGroup(headStore.next,kcurAnother,k);

            return kcur;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode h1 = new ListNode(1);
        head.next=h1;
        h1.next = new ListNode(2);
        h1.next.next = new ListNode(3);
        h1.next.next.next = new ListNode(4);
        h1.next.next.next.next= new ListNode(5);
        h1.next.next.next.next.next= new ListNode(6);
        h1.next.next.next.next.next.next = new ListNode(7);
        h1.next.next.next.next.next.next.next = new ListNode(8);
        h1.next.next.next.next.next.next.next.next = new ListNode(9);
        h1.next.next.next.next.next.next.next.next.next = new ListNode(10);
        h1.next.next.next.next.next.next.next.next.next.next = new ListNode(11);

//  0,1,2,3,4,5,6,7,8,9,10,11
//  3,2,1,0,4,5,6,7,8,9,10,11
//  3,2,1,0,7,6,5,4,7,8,9,10,11
//  3,2,1,0,7,6,5,4,10,9,8,7,11

        System.out.println(reverseKGroup(head,13));
    }
}
