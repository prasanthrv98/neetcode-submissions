class Solution {
    public List<List<String>> partition(String s) {
        List<String> curStr = new ArrayList<>();
        List<List<String>> res = new ArrayList<>();

        dfs(s, 0, curStr, res);
        return res;
    }

    public void dfs(String s, int start, List<String> cur, List<List<String>> res){

        if(start == s.length()){
            res.add(new ArrayList<>(cur));
            return;
        }

        for(int end = start; end < s.length(); end++){
            if(!isPalindrome(s, start, end)) continue;

            cur.add(s.substring(start, end + 1));
            dfs(s, end + 1, cur, res);
            cur.remove(cur.size() - 1);
        }
    }

    public boolean isPalindrome(String s, int left, int right){
        while(left < right){
            if(s.charAt(left++) != s.charAt(right--)) return false;
        }

        return true;
    }
}
