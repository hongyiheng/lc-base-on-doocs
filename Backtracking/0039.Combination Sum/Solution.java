class Solution {

    List<List<Integer>> ans = new ArrayList<>();
    int[] cancelAccount;
    int target;

    public void dfs(int i, int s, Deque<Integer> path) {
        if (i == cancelAccount.length || s >= target) {
            if (s == target) {
                ans.add(new ArrayList<>(path));
            }
            return;
        }
        path.addLast(cancelAccount[i]);
        dfs(i, s + cancelAccount[i], path);
        path.pollLast();
        dfs(i + 1, s, path);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.target = target;
        this.cancelAccount = candidates;
        dfs(0, 0, new ArrayDeque<>());
        return ans;
    }
}