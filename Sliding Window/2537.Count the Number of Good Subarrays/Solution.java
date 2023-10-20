class Solution {
    public long countGood(int[] nums, int k) {
        Map<Integer, Integer> g = new HashMap<>();
        long ans = 0, cur = 0;
        int l = 0, r = 0, n = nums.length;
        while (r < n) {
            cur += g.getOrDefault(nums[r], 0);
            g.put(nums[r], g.getOrDefault(nums[r], 0) + 1);
            while (cur >= k) {
                ans += n - r;
                cur -= (g.get(nums[l]) - 1);
                g.put(nums[l], g.get(nums[l]) - 1);
                l++;
            }
            r++;
        }
        return ans;
    }
}