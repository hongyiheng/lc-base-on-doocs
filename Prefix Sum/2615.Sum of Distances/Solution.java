class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        Map<Integer, List<Integer>> g = new HashMap<>();
        for (int i = 0; i < n; i++) {
            g.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        long[] ans = new long[n];
        for (List<Integer> arr : g.values()) {
            int m = arr.size();
            long[] s = new long[m + 1];
            for (int i = 0; i < m; i++) {
                s[i + 1] = s[i] + arr.get(i);
            }
            for (int i = 0; i < m; i++) {
                int v = arr.get(i);
                long l = 1L * v * i - s[i];
                long r = s[m] - s[i] - 1L * (m - i) * v;
                ans[v] = l + r;
            }
        }
        return ans;
    }
}