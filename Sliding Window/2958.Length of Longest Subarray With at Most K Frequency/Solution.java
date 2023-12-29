class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> g = new HashMap<>();
        int l = 0, r = 0, ans = 0;
        while (r < nums.length) {
            g.put(nums[r], g.getOrDefault(nums[r], 0) + 1);
            while (g.get(nums[r]) > k) {
                g.put(nums[l], g.get(nums[l]) - 1);
                l++;
            }
            ans = Math.max(ans, r - l + 1);
            r++;
        }
        return ans;
    }
}