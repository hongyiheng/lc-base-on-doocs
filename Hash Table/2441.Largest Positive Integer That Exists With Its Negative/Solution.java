class Solution {
    public int findMaxK(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int v : nums) {
            if (v < 0) {
                s.add(v);
            }
        }
        int ans = -1;
        for (int v : nums) {
            if (s.contains(-v)) {
                ans = Math.max(ans, v);
            }
        }
        return ans;
    }
}
