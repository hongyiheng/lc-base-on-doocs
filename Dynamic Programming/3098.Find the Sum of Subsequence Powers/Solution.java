class Solution {
    int n;
    int mod = (int)1e9 + 7;
    int[] nums;
    Map<String, Integer> f = new HashMap<>();

    public int dfs(int i, int j, int t, int mi) {
        if (i == n || t == 0) {
            return t == 0 ? mi : 0;
        }
        if (n - i < t) {
            return 0;
        }
        String key = i + ":" + j + ":" + t + ":" + mi;
        if (f.containsKey(key)) {
            return f.get(key);
        }
        int ans = dfs(i + 1, j, t, mi) % mod;
        if (j == -1) {
            ans = (ans + dfs(i + 1, i, t - 1, mi)) % mod;
        } else {
            ans = (ans + dfs(i + 1, i, t - 1, Math.min(mi, Math.abs(nums[i] - nums[j])))) % mod;
        }
        f.put(key, ans);
        return ans;
    }

    public int sumOfPowers(int[] nums, int k) {
        n = nums.length;
        Arrays.sort(nums);
        this.nums = nums;
        return dfs(0, -1, k, Integer.MAX_VALUE);
    }
}