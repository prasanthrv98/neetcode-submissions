class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> curSet = new ArrayList<>();
        List<List<Integer>> subSet = new ArrayList<>();

        dfs(0, nums, curSet, subSet);
        return subSet;
    }

    public void dfs(int index, int[] nums, List<Integer> curSet, List<List<Integer>> subSet){

        if(index == nums.length){
            subSet.add(new ArrayList<>(curSet));
            return;
        }

        curSet.add(nums[index]);
        dfs(index + 1, nums, curSet, subSet);
        curSet.remove(curSet.size() - 1);

        dfs(index + 1, nums, curSet, subSet);
    }
}
