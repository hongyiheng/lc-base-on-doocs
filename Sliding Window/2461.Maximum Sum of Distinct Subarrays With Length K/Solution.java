class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length, l = 0, r = 0;
        long ans = 0, cur = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        while (r < n) {
            while (r - l + 1 > k || mp.getOrDefault(nums[r], 0) > 0) {
                mp.put(nums[l], mp.get(nums[l]) - 1);
                cur -= nums[l];
                l++;
            }
            mp.put(nums[r], 1);
            cur += nums[r];
            if (r - l + 1 == k) {
                ans = Math.max(ans, cur);
            }
            r++;
        }
        return ans;
    }
}
