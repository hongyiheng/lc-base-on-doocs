class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        int ans = -1, n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                int mid = (left + right + 1) >> 1;
                if (nums[mid] + nums[i] < k) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            if (nums[left] + nums[i] < k && left != i) {
                ans = Math.max(ans, nums[left] + nums[i]);
            }
        }
        return ans;
    }
}