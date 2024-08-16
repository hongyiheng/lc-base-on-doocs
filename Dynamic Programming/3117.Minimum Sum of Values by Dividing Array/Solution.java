class Solution {

    int[] nums, andValues;
    Map<String, Integer> f;
    int n, m;
    int inf = 0x3f3f3f3f;

    public int dfs(int i, int j, int msk) {
        if (n - i < m - j) {
            return inf;
        }
        if (j == m) {
            return i == n ? 0 : inf;
        }
        String key = i + ":" + j + ":" + msk;
        if (f.containsKey(key)) {
            return f.get(key);
        }
        msk &= nums[i];
        int ans = dfs(i + 1, j, msk);
        if (msk == andValues[j]) {
            ans = Math.min(ans, dfs(i + 1, j + 1, -1) + nums[i]);
        }
        f.put(key, ans);
        return ans;
    }

    public int minimumValueSum(int[] nums, int[] andValues) {
        this.nums = nums;
        this.andValues = andValues;
        n = nums.length;
        m = andValues.length;
        f = new HashMap<>();
        int ans = dfs(0, 0, -1);
        return ans >= inf ? -1 : ans;
    }
}