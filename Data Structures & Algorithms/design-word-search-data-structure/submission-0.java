class TrieNode{
    HashMap<Character, TrieNode> children = new HashMap<>();
    boolean isWord = false;
}

class WordDictionary {
    private TrieNode root; 

    public WordDictionary() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {

        TrieNode cur = root;

        for(int i = 0; i < word.length(); i++){
            char c  = word.charAt(i);

            if(cur.children.get(c) == null) cur.children.put(c, new TrieNode());

            cur = cur.children.get(c); 
        }

        cur.isWord = true;
    }

    public boolean search(String word) {
       return dfs(root, word, 0);

    }

    public boolean dfs(TrieNode node, String word, int index){

        if(index == word.length()) return node.isWord;

        char c = word.charAt(index);

        if(c == '.'){
            for(TrieNode child: node.children.values()){
                if(dfs(child, word, index + 1)){
                    return true;
                }
            }
            return false;
        }
        else if(node.children.containsKey(c)){
            TrieNode nextNode = node.children.get(c);
            return dfs(nextNode, word, index + 1);
        } else return false;
        
    }
}
