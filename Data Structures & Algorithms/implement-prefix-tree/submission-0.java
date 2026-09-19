class TrieNode {
    HashMap<Character, TrieNode> children = new HashMap<>();
    boolean isWord = false;
 }

class PrefixTree {
    private TrieNode root;

    public PrefixTree() {
         this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = root;

        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);

            if(cur.children.get(c) == null) cur.children.put(c, new TrieNode());

            cur = cur.children.get(c);
        }
        cur.isWord = true;
    }

    public boolean search(String word) {
        TrieNode cur = root;

        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);

            if(!cur.children.containsKey(c)) return false;

            cur = cur.children.get(c);
        }

        return cur.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;

        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);

            if(!cur.children.containsKey(c)) return false;

            cur = cur.children.get(c);
        }

        return true;
    }
}


