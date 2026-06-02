class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int[] res = new int[nums.length];

        for(int i = 0; i < nums.length; i++){
            int count = 1;
            for(int j = 0; j < nums.length; j++){

                if(i != j){
                    count *=  nums[j];
                }
            }

            res[i] = count;
        }

        return res;
    }
}  
