class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> curset = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        dfs(0, nums, curset, res);

        return res;
     }

    public void dfs(int index, int[] nums, List<Integer> curset, List<List<Integer>> res){

        if(index == nums.length){
            res.add(new ArrayList<>(curset));
            return;
        } 
        

        curset.add(nums[index]);
        dfs(index + 1, nums, curset, res);
        curset.remove(curset.size() - 1);

        while(index < nums.length - 1 && nums[index] == nums[index + 1]){
            index++;
        }

        dfs(index + 1, nums, curset, res);
    }
}
