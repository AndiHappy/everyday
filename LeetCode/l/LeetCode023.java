package l;

import util.ListNode;

public class LeetCode023 {

//You are given an array of k linked-lists lists, each linked-list is sorted in
//ascending order.
//
// Merge all the linked-lists into one sorted linked-list and return it.
//
//
// Example 1:
//
//
//Input: lists = [[1,4,5],[1,3,4],[2,6]]
//Output: [1,1,2,3,4,4,5,6]
//Explanation: The linked-lists are:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//merging them into one sorted list:
//1->1->2->3->4->4->5->6
//
//
// Example 2:
//
//
//Input: lists = []
//Output: []
//
//
// Example 3:
//
//
//Input: lists = [[]]
//Output: []
//
//
//
// Constraints:
//
//
// k == lists.length
// 0 <= k <= 10^4
// 0 <= lists[i].length <= 500
// -10^4 <= lists[i][j] <= 10^4
// lists[i] is sorted in ascending order.
// The sum of lists[i].length won't exceed 10^4.
//

//
public ListNode mergeKLists(ListNode[] lists) {
    if(lists == null || lists.length==0) return null;
    if(lists.length == 1) return lists[0];
    return merger(lists,0,lists.length-1);
}

    public static ListNode merger(ListNode[] list, int from, int to){
        if(from == to) return list[from];
        int mid = from+ (to-from)/2;
        ListNode l1 = merger(list,from,mid);
        ListNode l2 = merger(list,mid+1,to);
        return mergeTwoList(l1,l2);
    }

    public static ListNode mergeTwoList(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            l1.next = mergeTwoList(l1.next,l2);
            return l1;
        }else{
            l2.next = mergeTwoList(l1,l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        System.out.println("keep happy");
    }
}
