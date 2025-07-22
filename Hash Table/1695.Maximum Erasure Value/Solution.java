class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n + 1];
        Map<Integer, Integer> pos = new HashMap<>();
        int ans = 0, last = 0;
        for (int i = 0; i < n; i++) {
            int v = nums[i];
            pre[i + 1] = pre[i] + v;
            if (pos.getOrDefault(v, 0) > last) {
                last = pos.get(v);
            }
            ans = Math.max(ans, pre[i + 1] - pre[last]);
            pos.put(v, i + 1);
        }
        return ans;
    }
}