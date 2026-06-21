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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode root = new ListNode(0);

        ListNode tail = root;
        int carry = 0;

        while(l1 != null || l2 != null || carry != 0){
            
            int value1 = l1 != null ? l1.val : 0;
            int value2 = l2 != null ? l2.val : 0;

            int sum = value1 + value2 + carry;

            carry = sum / 10;
            sum = sum % 10;

            tail.next = new ListNode(sum);
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
            tail = tail.next;
        }

        return root.next;
        
    }
}
