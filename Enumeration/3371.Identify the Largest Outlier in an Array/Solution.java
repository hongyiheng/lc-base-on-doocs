class Solution {
    public int getLargestOutlier(int[] nums) {
        int[] ns = new int[2010];
        int s = 0;
        for (int v : nums) {
            ns[v + 1000]++;
            s += v;
        }
        int ans = -1010;
        for (int v : nums) {
            if ((s - v) % 2 != 0) {
                continue;
            }
            int t = (s - v) / 2;
            if (t < -1000 || t > 1000) {
                continue;
            }
            if (ns[t + 1000] >= 2 || (ns[t + 1000] >= 1 && t != v)) {
                ans = Math.max(ans, v);
            }
        }
        return ans;
    }
}