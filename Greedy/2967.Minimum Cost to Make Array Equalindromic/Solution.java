class Solution {

    public long f(int[] nums, int x) {
        int cur = x, t = 0;
        while (cur != 0) {
            t = t * 10 + cur % 10;
            cur /= 10;
        }
        if (t != x) {
            return -1;
        }
        long ans = 0;
        for (int v : nums) {
            ans += Math.abs(x - v);
        }
        return ans;
    }

    public long minimumCost(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int mid = n / 2 != 0 || n == 1 ? nums[n / 2] : (nums[n / 2] + nums[n / 2 + 1]) / 2;
        long ans = Long.MAX_VALUE;
        for (int i = mid; i > -1; i--) {
            if (f(nums, i) != -1) {
                ans = f(nums, i);
                break;
            }
        }
        while (true) {
            if (f(nums, mid) != -1) {
                return Math.min(ans, f(nums, mid));
            }
            mid++;
        }
    }
}