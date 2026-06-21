class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;

        while(true){
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow == fast) break;
        }

        int newSlow = 0;
        while(true){
            slow = nums[slow];
            newSlow = nums[newSlow];

            if(slow == newSlow) break;
        }
        return newSlow;
    }
}
