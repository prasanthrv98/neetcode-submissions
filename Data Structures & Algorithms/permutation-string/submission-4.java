class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        Map<Character, Integer> hash = new HashMap<>();

// Map letter frequency for each letter
        for(char letter: s1.toCharArray()){
            int count = hash.getOrDefault(letter,0);
            hash.put(letter, count + 1);
        }
        
                int need = hash.size();

    for(int i = 0; i < s2.length(); i ++){
        Map<Character, Integer> hash2 = new HashMap<>();

    int cur = 0;
        for(int j = i; j < s2.length(); j++){

           char c = s2.charAt(j);

           hash2.put(c, hash2.getOrDefault(c,0) + 1);

           if(hash.getOrDefault(c,0) < hash2.get(c)){
            break;
           }

           if(hash.getOrDefault(c,0) == hash2.get(c)){
            cur++;

           }

           if(need == cur) return true;
              
        }
    }

    return false;
    }
}
