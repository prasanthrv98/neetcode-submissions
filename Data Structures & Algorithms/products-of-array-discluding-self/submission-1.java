class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int[] res = new int[nums.length];

        // brute force

        // for(int i = 0; i < nums.length; i++){
        //     int count = 1;
        //     for(int j = 0; j < nums.length; j++){

        //         if(i != j){
        //             count *=  nums[j];
        //         }
        //     }

        //     res[i] = count;
        // }

        // 1    2   4   6   - nums

        // 1    2   8   48  - prefix
        // 48   48  24    6 - postfix


        int[] prefix = new int[nums.length];
        int[] postfix = new int[nums.length];
        int n = nums.length;

        int prod = 1;
        for (int i = 0; i < nums.length; i++){
            prod *= nums[i]; 
           prefix[i] = prod;
        }


        prod = 1;
        for(int i = n - 1; i >= 0; i--){
            prod *= nums[i];
            postfix[i] = prod;
        }

     
        for(int i = 0; i < n; i++){

            int left = i > 0 ? prefix[i - 1] : 1;
            int right =  i < n - 1 ? postfix[i + 1] : 1;

            res[i] = left * right;

        }



        return res;
    }
}  
