class Solution {

    int target;
    int[] candidates;
    List<List<Integer>> ans;

    public void dfs(int i, int s, List<Integer> p, boolean skip) {
        if (s >= target || i >= candidates.length) {
            if (s == target) {
                ans.add(new ArrayList<>(p)); 
            }
            return;
        }
        if (skip && candidates[i] == candidates[i - 1]) {
            dfs(i + 1, s, p, skip);
            return;
        }
        s += candidates[i];
        p.add(candidates[i]);
        dfs(i + 1, s, p, false);
        s -= candidates[i];
        p.remove(p.size() - 1);
        dfs(i + 1, s, p, true);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.target = target;
        this.candidates = candidates;
        ans = new ArrayList<>();
        dfs(0, 0, new ArrayList<>(), false);
        return ans;
    }
}