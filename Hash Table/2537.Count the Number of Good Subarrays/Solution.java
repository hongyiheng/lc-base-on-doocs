class Solution {
    public long countGood(int[] nums, int k) {
        Map<Integer, Long> g = new HashMap<>();
        long ans = 0;
        int cur = 0, n = nums.length, l = 0;
        for (int r = 0; r < n; r++) {
            cur += g.getOrDefault(nums[r], 0L);
            g.put(nums[r], g.getOrDefault(nums[r], 0L) + 1);
            while (cur >= k) {
                ans += n - r;
                cur -= (g.get(nums[l]) - 1);
                g.put(nums[l], g.get(nums[l]) - 1);
                l++;
            }
        }
        return ans;
    }
}