class LRUCache {

    class Node{
        int key, value;
        Node prev, next;

        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    Map<Integer, Node> map = new HashMap<>();
    Node dummyHead = new Node(0, 0);
    Node dummyTail = new Node(0, 0);
    int capacity;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }

    public void addToFront(Node node){
        Node nextNode = dummyHead.next;
        dummyHead.next = node;
        
        node.next = nextNode;
        nextNode.prev = node;
        node.prev = dummyHead;
    }

    public void removeNode(Node node){
        Node nextNode = node.next;
        Node prevNode = node.prev;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
    
    public int get(int key) {

        if(map.get(key) == null){
            return -1;
        }

        Node curNode = map.get(key);
        int getVal = curNode.value;

        removeNode(curNode);
        addToFront(curNode);

        return getVal;
    }
    
    public void put(int key, int value) {
      
    //   if key already contains in cache, then update key and move it firstNode.
      if(map.containsKey(key)){
        Node curNode = map.get(key);
        curNode.value = value;

        removeNode(curNode);
        addToFront(curNode);
      } 
      else{
         Node newNode = new Node(key, value);
         map.put(key, newNode);

        addToFront(newNode);
      }
     
        // if cache capacity exceeds, then remove last node
        if(map.size() > capacity){
            int lastNodeKey = dummyTail.prev.key;
            Node lastNode = map.get(lastNodeKey);
            map.remove(lastNodeKey);
            removeNode(lastNode);
        }
    
    }

    
}
