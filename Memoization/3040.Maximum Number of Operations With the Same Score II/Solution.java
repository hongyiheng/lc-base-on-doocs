class Solution {

    Map<String, Integer> f;
    int[] nums;

    public int dfs(int l, int r, int t) {
        if (r - l + 1 < 2) {
            return 0;
        }
        String key = l + ":" + r + ":" + t;
        if (f.containsKey(key)) {
            return f.get(key);
        }
        int ans = 0;
        if (nums[l] + nums[l + 1] == t) {
            ans = Math.max(ans, dfs(l + 2, r, t) + 1);
        }
        if (nums[l] + nums[r] == t) {
            ans = Math.max(ans, dfs(l + 1, r - 1, t) + 1);
        }
        if (nums[r] + nums[r - 1] == t) {
            ans = Math.max(ans, dfs(l, r - 2, t) + 1);
        }
        f.put(key, ans);
        return ans;
    }

    public int maxOperations(int[] nums) {
        int n = nums.length;
        f = new HashMap<>();
        this.nums = nums;
        int ans = Math.max(dfs(0, n - 1, nums[0] + nums[1]), dfs(0, n - 1, nums[0] + nums[n - 1]));
        return Math.max(ans, dfs(0, n - 1, nums[n - 2] + nums[n - 1]));
    }
}