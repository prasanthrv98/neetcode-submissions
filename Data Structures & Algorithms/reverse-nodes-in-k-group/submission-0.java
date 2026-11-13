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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode before = dummy;


        while(true){

            ListNode last = before;
            for(int i = 0; i < k && last != null; i++){
                last = last.next;
            }

            if(last == null) return dummy.next;

            ListNode after = last.next;
            ListNode first = before.next;

            ListNode prev = after;
            ListNode curr = first;

            while(curr != after){
                ListNode next = curr.next;

                curr.next = prev;
                prev = curr;
                curr = next;
            }
            before.next = last;
            before = first;
        }
    }
}
