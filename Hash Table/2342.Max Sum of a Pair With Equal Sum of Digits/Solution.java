class Solution {
    public int maximumSum(int[] nums) {
        Map<Integer, Integer> g = new HashMap<>();
        int ans = -1;
        for (int v : nums) {
            int t = v, k = 0;
            while (t > 0) {
                k += t % 10;
                t /= 10;
            }
            int nv = g.getOrDefault(k, 0);
            if (nv > 0) {
                ans = Math.max(ans, nv + v);
            }
            g.put(k, Math.max(nv, v));
        }
        return ans;
    }
}