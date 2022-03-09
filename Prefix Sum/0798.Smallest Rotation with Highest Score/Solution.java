class Solution {
    public int bestRotation(int[] nums) {
        int n = nums.length;
        int[] cnt = new int[n];
        for (int i = 0; i < n; i++) {
            cnt[(i + 1) % n]++;
            cnt[(n + i - nums[i] + 1) % n]--;
        }
        int cur = 0, mx = -1, ans = 0;
        for (int i = 0; i < n; i++) {
            cur += cnt[i];
            if (cur > mx) {
                mx = cur;
                ans = i;
            }
        }
        return ans;
    }
}