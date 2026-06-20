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

         Node dummyNode = new Node(0);
        Map<Node, Node> hashmap = new HashMap<>();

        Node cur = head;

        //  first loop to set the hashmap
        int iteration = 1;
        while(cur != null){

            if(iteration == 1) {
                Node firstNode = new Node(cur.val); // capture the first new node
                dummyNode.next = firstNode;
                hashmap.put(cur, firstNode);
            } else hashmap.put(cur, new Node(cur.val));

            iteration++;
            cur = cur.next;
        }

        //second loop to set the new node's random pointer

        cur = head;
       
        Node next = null;
        while(cur != null){
            Node randomNode = cur.random;

            Node newNode = hashmap.get(cur);
            newNode.next = hashmap.get(cur.next);

            newNode.random = hashmap.get(randomNode);

            cur = cur.next;
        }

        return dummyNode.next;
    }
}
