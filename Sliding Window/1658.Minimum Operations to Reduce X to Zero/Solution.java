class Solution {
    public int minOperations(int[] nums, int x) {
        int s = 0;
        for (int v : nums) {
            s += v;
        }
        int n = nums.length, t = s - x;
        if (t < 0) {
            return -1;
        }
        if (t == 0) {
            return n;
        }
        int left = 0, right = 0, cur = 0, ans = 0;
        while (right < n) {
            cur += nums[right];
            while (cur > t) {
                cur -= nums[left];
                left++;
            }
            if (cur == t) {
                ans = Math.max(ans, right - left + 1);
            }
            right++;
        }
        return ans == 0 ? -1 : n - ans;
    }
}