class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> curComb = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        int sum = 0;

        dfs(0, sum, target, nums,curComb, res);
        return res;
    }

    public void dfs(int index, int sum, int target, int[] nums,List<Integer> curComb, List<List<Integer>> res){

        if(sum == target) {
            res.add(new ArrayList<>(curComb));
            return;
        }
        else if(sum > target || index == nums.length) return;
  


        curComb.add(nums[index]);

        dfs(index, sum + nums[index], target, nums, curComb, res);
        curComb.remove(curComb.size() - 1);

        dfs(index + 1, sum, target, nums, curComb, res);

    }


}
