class Solution {
    public int largestCombination(int[] candidates) {
        int[] f = new int[32];
        for (int v : candidates) {
            for (int i = 0; i < 32; i++) {
                if ((v >> i & 1) != 0) {
                    f[i]++;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans = Math.max(f[i], ans);
        }
        return ans;
    }
}