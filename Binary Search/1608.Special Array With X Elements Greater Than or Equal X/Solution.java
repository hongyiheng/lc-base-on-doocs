class Solution {
    public int specialArray(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i <= n; i++) {
            int left = 0, right = n;
            while (left < right) {
                int mid = (left + right) >> 1;
                if (nums[mid] < i) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            if (n - left == i) {
                return i;
            }
        }
        return -1;
    }
}