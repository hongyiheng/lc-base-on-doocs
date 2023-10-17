class Solution {
    public int getXMin(int[]cnt, int x) {
        int t = x;
        for (int i = 0; i < 110; i++) {
            if (cnt[i] >= t) {
                return i <= 50 ? i - 50 : 0;
            }
            t -= cnt[i];
        }
        return 0;
    }

    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int[] cnt = new int[110];
        int l = 0, r = 0;
        while (r < n) {
            cnt[nums[r] + 50]++;
            if (r - l + 1 == k) {
                ans[l] = getXMin(cnt, x);
                cnt[nums[l] + 50]--;
                l++;
            }
            r++;
        }
        return ans;
    }
}