class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int sum = 0;
        List<Integer> curComb = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

// sort the duplicate numbers
        Arrays.sort(candidates);

        dfs(0, sum, target, candidates, curComb, res);

        return res;
     }

    public void dfs(int index, int sum, int target, int[] candidates, List<Integer> curComb, List<List<Integer>> res){

        if(sum == target){
            res.add(new ArrayList<>(curComb));
            return;
        } 
        else if(sum > target || index == candidates.length) return;


        // add a numb
        curComb.add(candidates[index]);
        dfs(index + 1, sum + candidates[index], target, candidates, curComb, res);
        curComb.remove(curComb.size() - 1);

        // skip a numb
        while(index < candidates.length - 1 && candidates[index] == candidates[index + 1]){
            index++;
        }

        dfs(index + 1, sum, target, candidates, curComb, res);

    }
}
