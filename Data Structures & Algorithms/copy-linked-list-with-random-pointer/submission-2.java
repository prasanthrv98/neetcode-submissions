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
        HashMap<Node, Node> map = new HashMap<>();
        Node cur = head;

        while(cur != null){

            Node newNode = new Node(cur.val);
            map.put(cur, newNode);
            cur = cur.next;
        }

        cur = head;
        while(cur != null){
            Node newNode = map.get(cur);
            Node newNodeNext = map.get(cur.next);
            Node newNodeRandom = map.get(cur.random);
            
            newNode.next = newNodeNext;
            newNode.random = newNodeRandom;

            cur = cur.next;
             
        }

        return map.get(head);
    }
}
