class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();

        for (String word: strs){
            int[] keyMappings = new int[26];

            for (char letter: word.toCharArray()){
                int letterKey = letter - 'a';
                keyMappings[letterKey]++;
            }

            String wordKey = Arrays.toString(keyMappings);
            res.putIfAbsent(wordKey, new ArrayList<>());
            res.get(wordKey).add(word);
        }

        return new ArrayList<>(res.values());
     }
}
