class Solution {
    public long countAlternatingSubarrays(int[] nums) {
        long ans = 1, cur = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] != nums[i]) {
                cur++;
            } else {
                cur = 1;
            }
            ans += cur;
        }
        return ans;
    }
}