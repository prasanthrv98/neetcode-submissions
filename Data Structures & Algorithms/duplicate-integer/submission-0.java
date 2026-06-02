class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> numCounts = new HashSet<>();

        
        for(int num: nums){
            if(numCounts.contains(num)){
                return true;
            }

            numCounts.add(num);
        }

        return false;


    }
}