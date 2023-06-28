class Solution {

    int n;
    int t;
    int[] nums;
    int[][] f;

    public int getNext(int mask) {
        for (int i = 0; i < n; i++) {
            if ((mask >> i & 1) == 0) {
                return i;
            }
        }
        return 0;
    }

    public int dfs(int mask, int idx) {
        if (mask == (1 << n) - 1) {
            return 0;
        }
        if (f[mask][idx] != -1) {
            return f[mask][idx];
        }
        if (Integer.bitCount(mask) % t == 0) {
            int i = getNext(mask);
            return dfs(mask | 1 << i, i);
        }
        int ans = 0x3f3f3f3f;
        int last = nums[idx];
        for (int i = idx + 1; i < n; i++) {
            if ((mask >> i & 1) != 0 || nums[i] == last) {
                continue;
            }
            last = nums[i];
            ans = Math.min(ans, last - nums[idx] + dfs(mask | 1 << i, i));
        }
        f[mask][idx] = ans;
        return ans;
    }

    public int minimumIncompatibility(int[] nums, int k) {
        n = nums.length;
        int[] cnt = new int[n + 1];
        for (int v : nums) {
            if (++cnt[v] > k) {
                return -1;
            }
        }
        Arrays.sort(nums);
        this.nums = nums;
        t = n / k;
        f = new int[1 << n][n];
        for (int[] r : f) {
            Arrays.fill(r, -1);
        }
        return dfs(0, 0);
    }
}