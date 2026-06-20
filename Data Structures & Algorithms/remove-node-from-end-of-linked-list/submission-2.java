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

        ListNode cur = head;

        //find the length of the nodes
        int listLength = 0;
        while(cur != null){
            listLength++;
            cur = cur.next;
        }

        int prevIndex = listLength - n;

        int index = 0;
        cur = head;
       
        if(prevIndex == 0) return head.next;

        while(cur != null){
            index++;
            if(index == prevIndex){
                cur.next = cur.next.next;
                break;
            }
            cur = cur.next;
        }

        return head;

    }
}
