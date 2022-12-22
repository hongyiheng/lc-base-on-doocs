class Solution {
    public int maxScore(int[] nums) {
        int n = nums.length;
        int[] f = new int[1 << n];
        int ans = 0;
        for (int k = 0; k < (1 << n); k++) {
            int cnt = getCnt(k);
            if (cnt % 2 != 0) {
                continue;
            }
            for (int i = 0; i < n; i++) {
                if ((k & (1 << i)) == 0) {
                    continue;
                }
                for (int j = i + 1; j < n; j++) {
                    if ((k & (1 << j)) == 0) {
                        continue;
                    }
                    f[k] = Math.max(f[k], f[(k ^ (1 << i) ^ (1 << j))] + cnt / 2 * gcd(nums[i], nums[j]));
                    ans = Math.max(ans, f[k]);
                }
            }
        }
        return ans;
    }

    public int getCnt(int x) {
        int ans = 0;
        while (x != 0) {
            x -= x & -x;
            ans++;
        }
        return ans;
    }

    public int gcd(int a, int b) {
        if (b != 0) {
            return gcd(b, a % b);
        }
        return a;
    }
}