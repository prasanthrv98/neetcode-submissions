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
    public void reorderList(ListNode head) {
        
        // find middle node
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode second = slow.next;
        ListNode prev = slow.next = null;

        // reverse the second set of nodes
        while(second != null){
            ListNode next = second.next;
            second.next = prev;
            prev = second;
            second = next;
        }

        //[head = 0 -> 1 -> 2 -> 3 -> null  null <- 4 <- 5 <- 6 = prev]

        ListNode first = head;
        second = prev;

        while(second != null){
            ListNode firstNext = first.next;
            ListNode secondNext = second.next;

            first.next = second;
            second.next = firstNext;

            first = firstNext;
            second = secondNext;
        }



    }
}
