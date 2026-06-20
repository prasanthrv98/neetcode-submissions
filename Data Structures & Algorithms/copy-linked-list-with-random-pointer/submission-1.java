/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {

        
        Map<Node, Node> hashmap = new HashMap<>();

        Node cur = head;

        //  first loop to set the hashmap
        while(cur != null){
           hashmap.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        //second loop to set the new node's random pointer
        cur = head;

        while(cur != null){
            Node newNode = hashmap.get(cur);
            newNode.next = hashmap.get(cur.next);
            newNode.random = hashmap.get(cur.random);

            cur = cur.next;
        }

        return hashmap.get(head);
    }
}
