class Solution {

    public int searchLeft(int[] nums, int l, int x) {
        int r = nums.length;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[mid] < x) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return r;
    }

    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int v = nums[i];
            int l = searchLeft(nums, i + 1, lower - v);
            int r = searchLeft(nums, i + 1, upper - v + 1) - 1;
            if (r >= l) {
                ans += (long)r - l + 1;
            }
        }
        return ans;
    }
}