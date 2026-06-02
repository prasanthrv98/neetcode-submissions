class Solution {
    public int[] twoSum(int[] nums, int target) {

        // for(int i = 0; i < nums.length - 1; i++){
        //     for(int j = i + 1; j < nums.length; j++){
        //         int sum = nums[i] + nums[j];

        //         if(sum == target) return new int[] {i,j};
        //     }
        // }

        Map<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            int diff = target - nums[i];

            if(indexMap.containsKey(diff)){
                int firstIndex = indexMap.get(diff);
                return new int[] {firstIndex, i};
            } else{
                indexMap.put(nums[i], i);
            }
        }

        return new int[] {0,0};
    }
}
