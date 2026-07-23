class Solution {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        while(l < r){

            while(l < r && !isAlphaNum(s.charAt(l))){
                l++;
            }

            while(r > l && !isAlphaNum(s.charAt(r))){
                r--;
            }

            if(Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) return false;
            l++;
            r--;
        }

        return true;
    }

    public boolean isAlphaNum(char c){
        if(c >= 'a' && c <= 'z' ||
           c >= 'A' && c <= 'Z' ||
           c >='0' && c <= '9') return true;
        else return false;   
    }
}
