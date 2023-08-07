class Solution {

    int mod = (int) 1e9 + 7;
    int n;
    int[] nums;
    Map<String, Integer> f = new HashMap<>();

    public int dfs(int use, int pre) {
        String key = use + ":" + pre;
        if (f.containsKey(key)) {
            return f.get(key);
        }
        if (use == (1 << n) - 1) {
            return 1;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if ((use >> i & 1) == 0 && (pre % nums[i] == 0 || nums[i] % pre == 0)) {
                ans = (ans + dfs(use | (1 << i), nums[i])) % mod;
            }
        }
        f.put(key, ans);
        return ans;
    }

    public int specialPerm(int[] nums) {
        n = nums.length;
        this.nums = nums;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = (ans + dfs(1 << i, nums[i])) % mod;
        }
        return ans;
    }
}