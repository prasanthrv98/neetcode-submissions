class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];

//    1. detect the cycle
        while(slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
//  2. set new pointer and move slow and new pointer to detect the duplicate

        int pointer2 = 0;

        while(true){
            slow = nums[slow];
            pointer2 = nums[pointer2];

            if(slow == pointer2) break;
        }

        return slow;

    }
}
