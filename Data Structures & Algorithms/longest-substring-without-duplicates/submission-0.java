class Solution {
    public int lengthOfLongestSubstring(String s) {

        int l = 0, len = 0, res = 0;

        Set<Character> map = new HashSet<>();


        for(int r = 0; r < s.length(); r++){

            while(map.contains(s.charAt(r))){
                map.remove(s.charAt(l));
                l++;
                len--;
            } 
               map.add(s.charAt(r));
                len++;
                res = Math.max(res, len);
            
        }

    
        return res;
        
    }
}
