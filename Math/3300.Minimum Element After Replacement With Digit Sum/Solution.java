class Solution {
    public int minElement(int[] nums) {
        int ans = nums[0];
        for (int v : nums) {
            int s = 0;
            while (v > 0) {
                s += v % 10;
                v /= 10;
            }
            ans = Math.min(ans, s);
        }
        return ans;
    }
}