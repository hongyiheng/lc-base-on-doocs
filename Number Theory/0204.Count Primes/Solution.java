class Solution {
    public int countPrimes(int n) {
        boolean[] nums = new boolean[n];
        for (int i = 2; i < n; i++) {
            if (!nums[i]) {
                long x = 1L * i * i;
                while (x < n) {
                    nums[(int)x] = true;
                    x += i;
                }
            }
        }
        int ans = 0;
        for (int i = 2; i < n; i++) {
            if (!nums[i]) {
                ans++;
            }
        }
        return ans;
    }
}
