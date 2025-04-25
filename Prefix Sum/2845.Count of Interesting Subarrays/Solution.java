class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        int n = nums.size();
        int[] pre = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + (nums.get(i) % modulo == k ? 1 : 0);
        }
        Map<Integer, Integer> g = new HashMap<>();
        long ans = 0;
        for (int v : pre) {
            if (v >= k) {
                ans += g.getOrDefault((v - k) % modulo, 0);
            }
            g.put(v % modulo, g.getOrDefault(v % modulo, 0) + 1);
        }
        return ans;
    }
}