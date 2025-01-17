class Solution {

    public int getVal(int[] s) {
        int ans = 0;
        for (int i = 0; i < 31; i++) {
            if (s[i] > 0) {
                ans |= 1 << i;
            }
        }
        return ans;
    }

    public int minimumSubarrayLength(int[] nums, int k) {
        if (k == 0) {
            return 1;
        }
        int n = nums.length;
        int l = 0, r = 0, ans = n + 1;
        int[] s = new int[32];
        while (r < n) {
            for (int i = 0; i < 31; i++) {
                if ((nums[r] >> i & 1) == 1) {
                    s[i]++;
                }
            }
            while (getVal(s) >= k) {
                ans = Math.min(ans, r - l + 1);
                for (int i = 0; i < 31; i++) {
                    if ((nums[l] >> i & 1) == 1) {
                        s[i]--;
                    }
                }
                l++;
            }
            r++;
        }
        return ans > n ? -1 : ans;
    }
}