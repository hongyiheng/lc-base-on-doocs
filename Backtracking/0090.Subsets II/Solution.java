class Solution {
    Set<List<Integer>> ans;
    int[] nums;
    int n;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        n = nums.length;
        ans = new HashSet<>();
        Deque<Integer> path = new ArrayDeque<>();
        dfs(path, 0, 0);
        return new ArrayList(ans);
    }

    public void dfs(Deque<Integer> path, int idx, int cur) {
        if (idx == n) {
            ans.add(new ArrayList(path));
            return;
        }
        for (int i = cur; i < n; i++) {
            path.addLast(nums[i]);
            dfs(path, idx + 1, i + 1);
            path.pollLast();
            dfs(path, idx + 1, i + 1);
        }
    }
}