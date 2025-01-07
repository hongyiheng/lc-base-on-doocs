class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        if (k == 1) {
            return true;
        }
        int n = nums.size(), cnt = 1;
        boolean[] f = new boolean[n];
        for (int i = 1; i < n; i++) {
            if (nums.get(i - 1) < nums.get(i)) {
                cnt++;
            } else {
                cnt = 1;
            }
            if (cnt >= k) {
                f[i] = true;
                if (i - k >= 0 && f[i - k]) {
                    return true;
                }
            }
        }
        return false;
    }
}