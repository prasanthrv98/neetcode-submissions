class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder cur = new StringBuilder();

        dfs(0,0, n, cur, res);

        return res;
    }

    public void dfs(int open, int close, int n, StringBuilder cur, List<String> res){
        
        if(cur.length() == 2*n){
            res.add(cur.toString());
            return;
        }

        if(open < n){
            cur.append('(');
            

            dfs(open + 1, close, n, cur, res);

            cur.deleteCharAt(cur.length() - 1);
            
        } 
       if(close < open){
            cur.append(')');
      

            dfs(open, close + 1, n, cur, res);

            cur.deleteCharAt(cur.length() - 1);
            
        }
    }
}
