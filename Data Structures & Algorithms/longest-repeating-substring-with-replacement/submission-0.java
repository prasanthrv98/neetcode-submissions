class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();

        int l = 0, maxf = 0, res = 0;


        for(int r = 0; r < s.length(); r++){

            int windowSize = r - l + 1;
            char currentChar = s.charAt(r);
            int charCount = map.getOrDefault(currentChar, 0);


            map.put(currentChar, charCount + 1);

            maxf = Math.max(map.get(currentChar), maxf);

            if(windowSize - maxf > k){
                Integer currentCharCount = map.get(s.charAt(l));
                map.put(s.charAt(l), currentCharCount - 1);
                l++;
            }

            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}
