class Solution {
    public long countBadPairs(int[] nums) {
        Map<Integer, Integer> g = new HashMap<>();
        long ans = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            int v = g.getOrDefault(nums[i] - i, 0);
            ans += v;
            g.put(nums[i] - i, v + 1);
        }
        return (long)n * (n - 1) / 2 - ans;
    }
}