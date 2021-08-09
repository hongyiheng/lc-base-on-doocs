class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Deque<Integer> path = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(path, candidates, res, target, 0);
        return res;
    }

    public void dfs(Deque<Integer> path, int[] candidates, List<List<Integer>> res, int target, int begin) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(path));
        }
        for (int i = begin; i < candidates.length; i++) {
            if (candidates[i] > target) {
                continue;
            }
            path.addLast(candidates[i]);
            dfs(path, candidates, res, target - candidates[i], i);
            path.removeLast();
        }
    }

}