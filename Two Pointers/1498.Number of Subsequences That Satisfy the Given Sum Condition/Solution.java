class Solution {

    int mod = (int) 1e9 + 7;

    public int numSubseq(int[] nums, int target) {
        int n = nums.length;
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i < n; i++) {
            f[i] = f[i - 1] * 2 % mod;
        }
        Arrays.sort(nums);
        long ans = 0;
        int l = 0, r = n - 1;
        while (l <= r) {
            if (nums[l] + nums[r] <= target) {
                ans += f[r - l];
                l++;
            } else {
                r--;
            }
        }
        return (int)(ans % mod);
    }
}