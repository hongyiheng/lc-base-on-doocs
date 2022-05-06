class Solution {
    int[] nums;
    public int missingElement(int[] nums, int k) {
        this.nums = nums;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right + 1) >> 1;
            if (getLack(mid) < k) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return nums[left] - getLack(left) + k;
    }

    public int getLack(int x) {
        return nums[x] - nums[0] - x;
    }
}