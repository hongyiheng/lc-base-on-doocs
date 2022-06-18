class Solution {
    public int minSwaps(int[] nums) {
        int win = 0, n = nums.length;
        for (int num : nums) {
            win += num;
        }
        if (win == 0 || win == n) {
            return 0;
        }
        int[] count = new int[n + win];
        for (int i = 0; i < win; i++) {
            count[0] += nums[i];
        }
        for (int i = 1; i < n; i++) {
            int right = (i + win - 1) % n;
            count[i] = count[i - 1] + nums[right] - nums[i - 1];
        }
        int ans = n;
        for (int num : count) {
            ans = Math.min(ans, win - num);
        }
        return ans;
    }
}