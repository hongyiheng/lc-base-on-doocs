class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int mi = nums[0], ans = 1;
        for (int v : nums) {
            if (v - mi > k) {
                mi = v;
                ans++;
            }
        }
        return ans;
    }
}