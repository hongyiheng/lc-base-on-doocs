class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int ans = 0, n = nums.length;
        int left = 1, right = 1;
        for (int num : nums) {
            right = Math.max(right, num);
        }
        while (left < right) {
            int mid = (left + right) >> 1;
            if (check(nums, mid, maxOperations)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean check(int[] nums, int x, int k) {
        for (int num : nums) {
            k -= (num - 1) / x;
        }
        return k >= 0;
    }
}