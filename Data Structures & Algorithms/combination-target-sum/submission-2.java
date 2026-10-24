class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> curSet = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();


        dfs(0, nums, target, 0, curSet, res);

        return res;
    }

    public void dfs(int index, int[] nums, int target, int sum, List<Integer> curSet, List<List<Integer>> res){

        if(target == sum){
            res.add(new ArrayList<>(curSet));
            return;
        }
        else if(sum > target || index == nums.length){
            return;
        }


        curSet.add(nums[index]);
        dfs(index, nums, target, sum + nums[index], curSet, res);
        curSet.remove(curSet.size() - 1);

        dfs(index + 1, nums, target, sum, curSet, res);
    } 
}
