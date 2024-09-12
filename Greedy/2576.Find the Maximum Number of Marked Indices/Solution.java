class Solution {
    public int maxNumOfMarkedIndices(int[] nums) {
        Arrays.sort(nums);
        int l = 0, n = nums.length;
        for (int i = (n + 1) / 2; i < n; i++) {
            if (nums[l] * 2 <= nums[i]) {
                l++;
            }
        }
        return l * 2;
    }
}