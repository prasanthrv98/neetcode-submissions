class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> hash = new HashSet<>();

        for(int num: nums){
            hash.add(num);
        }
        int longest = 0;
        for(int num: nums){
            //  longest = 1;
            if(!hash.contains(num - 1)){
                 int length = 1;
                 
                while(hash.contains(num + length)){
                    length++;
                }

                longest = Math.max(longest,length);
            }
           
        }

        return longest;
    }
}
