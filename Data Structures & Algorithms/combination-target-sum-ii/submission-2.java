class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> curset = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(candidates);

        dfs(0, 0, target, candidates, curset, res);

        return res;
    }

    public void dfs(int index, int sum, int target, int[] candidates, List<Integer> curset, List<List<Integer>> res){

        if(sum == target){
            res.add(new ArrayList<>(curset));
            return;
        } 
        else if(sum > target || index == candidates.length) return;


// add a number
        curset.add(candidates[index]);
        dfs(index + 1, sum + candidates[index], target, candidates, curset, res);
        curset.remove(curset.size() - 1);

//  skip a number 

        while(index < candidates.length - 1 && candidates[index] == candidates[index + 1])  {
            index++;
        }

        dfs(index + 1, sum, target, candidates, curset, res);

    }
}
