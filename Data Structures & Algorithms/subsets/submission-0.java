class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subset = new ArrayList<>();
        List<Integer> curSet = new ArrayList<>();

        dfs(0, nums, subset, curSet);

        return subset;
    }

    public void dfs(int index, int[] nums, List<List<Integer>> subsets, List<Integer> curSet){
        if(index == nums.length){
            subsets.add(new ArrayList<>(curSet));
            return;
        }

        curSet.add(nums[index]);
        // add a number
        dfs(index + 1, nums, subsets, curSet);
        curSet.remove(curSet.size() - 1);

//      remove a number
        dfs(index+1, nums, subsets, curSet);
    }
}
