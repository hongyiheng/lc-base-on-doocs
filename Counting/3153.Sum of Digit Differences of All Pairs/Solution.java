class Solution {
    public long sumDigitDifferences(int[] nums) {
        int m = nums.length, n = String.valueOf(nums[0]).length();
        long[][] s = new long[n][10];
        long ans = 0;
        for (int i = 0; i < m; i++) {
            int v = nums[i];
            for (int j = 0; j < n; j++) {
                s[j][v % 10] += 1;
                ans += i + 1 - s[j][v % 10];
                v /= 10;
            }
        }
        return ans;
    }
}