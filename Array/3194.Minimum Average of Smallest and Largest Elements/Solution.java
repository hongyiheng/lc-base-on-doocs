class Solution {
    public double minimumAverage(int[] nums) {
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;
        double ans = 50;
        while (l < r) {
            ans = Math.min((nums[r--] + nums[l++]) / 2.0, ans);
        }
        return ans;
    }
}