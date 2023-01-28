class Solution {
    public int waysToMakeFair(int[] nums) {
        int n = nums.length;
        int[][] s = new int[n + 1][2];
        for (int i = 1; i < n + 1; i++) {
            s[i][0] = s[i - 1][0];
            s[i][1] = s[i - 1][1];
            if ((i - 1) % 2 == 1) {
                s[i][1] += nums[i - 1];
            } else {
                s[i][0] += nums[i - 1];
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int odd = 0, even = 0;
            if (i % 2 == 1) {
                odd = s[n][0] - s[i + 1][0] + s[i + 1][1] - nums[i];
                even = s[n][1] - s[i + 1][1] + s[i + 1][0];
            } else {
                even = s[n][1] - s[i + 1][1] + s[i + 1][0] - nums[i];
                odd = s[n][0] - s[i + 1][0] + s[i + 1][1];
            }
            if (odd == even) {
                ans++;
            }
        }
        return ans;
    }
}