class Solution {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int n = nums.length;
        int mi = nums[0], mx = nums[0], miIdx = 0, mxIdx = 0;
        for (int i = indexDifference; i < n; i++) {
            int v = nums[i], l = i - indexDifference;
            if (nums[l] < mi) {
                mi = nums[l];
                miIdx = l;
            }
            if (nums[l] > mx) {
                mx = nums[l];
                mxIdx = l;
            }
            if (Math.abs(mi - v) >= valueDifference) {
                return new int[]{miIdx, i};
            }
            if (Math.abs(mx - v) >= valueDifference) {
                return new int[]{mxIdx, i};
            }
        }
        return new int[]{-1, -1};
    }
}