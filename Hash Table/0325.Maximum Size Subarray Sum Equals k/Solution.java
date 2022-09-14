class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int ans = 0, n = nums.length;
        long[] pre = new long[n + 1];
        Map<Long, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + nums[i];
            if (!mp.containsKey(pre[i + 1])) {
                mp.put(pre[i + 1], i);
            }
        }
        for (int i = 0; i < n; i++) {
            long cur = pre[i + 1];
            if (cur == k) {
                ans = Math.max(ans, i + 1);
            }
            int j = mp.getOrDefault(cur - k, -1);
            if (j != -1 && j < i) {
                ans = Math.max(ans, i - j);
            }
        }
        return ans;
    }
}