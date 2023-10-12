class Solution {
    public long findTheArrayConcVal(int[] nums) {
        int l = 0, r = nums.length - 1;
        long ans = 0;
        while (l < r) {
            ans += Integer.valueOf(String.valueOf(nums[l++]) + nums[r--]);
        }
        return l == r ? ans + nums[r] : ans;
    }
}