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
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse the 2nd half
        ListNode second = slow.next;
        ListNode prev = slow.next = null;

        while(second != null){
            ListNode next = second.next;
            second.next = prev;
            prev = second;
            second = next;
        }

        ListNode first = head;
        second = prev;

        while(second != null){
            // store temp for next pointers
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            // merge
            first.next = second;
            second.next = temp1;    

            // reset pointer
            first = temp1;
            second = temp2;
        }



        
    }
}
