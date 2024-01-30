class Solution {
    public int minimumSeconds(List<Integer> nums) {
        int ans = nums.size(), n = nums.size();
        Map<Integer, List<Integer>> g = new HashMap<>();
        for (int i = 0; i < n; i++) {
            g.computeIfAbsent(nums.get(i), k -> new ArrayList()).add(i);
        }
        for (List<Integer> q : g.values()) {
            int d = n - (q.get(q.size() - 1) - q.get(0) + 1);
            for (int i = 1; i < q.size(); i++) {
                d = Math.max(d, q.get(i) - q.get(i - 1) - 1);
            }
            ans = Math.min(ans, (d + 1) / 2);
        }
        return ans;
    }
}