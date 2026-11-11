class Solution {
      private static final Map<Character, String> letterHash = Map.of(
        '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
        '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz"
    );

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.isEmpty()) return res;

        dfs(digits, 0, new StringBuilder(), res);

        return res;
    }

    public void dfs(String digits, int index, StringBuilder cur, List<String> res){
        if(index == digits.length()){
            res.add(cur.toString());
            return;
        }

        String letters = letterHash.get(digits.charAt(index));

        for(int i = 0 ; i < letters.length(); i++){
            char c = letters.charAt(i);

            cur.append(c);
            dfs(digits,index + 1, cur, res);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
