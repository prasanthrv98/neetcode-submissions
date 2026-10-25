class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curset = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        dfs(nums, used, curset, res);

        return res;
    }

    public void dfs(int[] nums, boolean[] used, List<Integer> curset, List<List<Integer>> res){

        if(curset.size() == nums.length){
            res.add(new ArrayList<>(curset));
            return;
        }


        for(int i = 0; i < nums.length; i++){
            if(used[i]) continue;

            curset.add(nums[i]);
            used[i] = true;

            dfs(nums, used, curset, res);

            curset.remove(curset.size() - 1);
            used[i] = false;


        }
    }
}
