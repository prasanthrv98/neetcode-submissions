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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = dummy;

        // move the fast untill nth position
        // dummy -> 10 -> 20 -> 30 -> 40
        for(int i = 0; i < n; i++){
            fast = fast.next;
        }

        // move the slow and fast one step each till fast reaches end 
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }

        // now slow is at one node before nth node

        if(slow.next != null) slow.next = slow.next.next;
        else slow.next = null;

        return dummy.next;


    }
}
