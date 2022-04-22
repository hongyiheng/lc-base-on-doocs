class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int s = 0;
        long cur = 0;
        for (int i = 0; i < n; i++) {
            s += nums[i];
            cur += i * nums[i];
        }
        long ans = cur;
        int last = n - 1;
        for (int k = 1; k < n; k++) {
            cur = cur - n * nums[last] + s;
            ans = Math.max(ans, cur);
            last = (last - 1 + n) % n;
        }
        return (int)ans;
    }
}