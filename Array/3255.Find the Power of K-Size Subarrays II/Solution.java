class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int cnt = 1;
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i - 1] + 1 == nums[i]) {
                cnt++;
            } else {
                cnt = 1;
            }
            if (i >= k - 1) {
                ans[i - k + 1] = cnt >= k ? nums[i] : -1;
            }
        }
        return ans;
    }
}