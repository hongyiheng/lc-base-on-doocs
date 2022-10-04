class Solution {
    List<List<Integer>> ans;
    Set<String> s;
    int[] nums;
    int n;

    public List<List<Integer>> findSubsequences(int[] nums) {
        ans = new ArrayList<>();
        this.nums = nums;
        n = nums.length;
        Deque<Integer> path = new ArrayDeque<>();
        boolean[] vis = new boolean[n];
        s = new HashSet<>();
        dfs(path, vis, 0);
        return ans;
    }

    public void dfs(Deque<Integer> path, boolean[] vis, int idx) {
        if (path.size() >= 2) {
            String h = hash(path);
            if (!s.contains(h)) {
                ans.add(new ArrayList(path));
                s.add(h);
            }
        }
        if (idx >= n) {
            return;
        }
        for (int i = idx; i < n; i++) {
            if (!path.isEmpty() && path.peekLast() > nums[i]) {
                continue;
            }
            if (vis[i]) {
                continue;
            }
            vis[i] = true;
            path.addLast(nums[i]);
            dfs(path, vis, i + 1);
            path.pollLast();
            vis[i] = false;
        }
    }

    public String hash(Deque<Integer> q) {
        StringBuilder sb = new StringBuilder();
        for (int v : q) {
            sb.append(String.valueOf(v) + "-");
        }
        return sb.toString();
    }
}
