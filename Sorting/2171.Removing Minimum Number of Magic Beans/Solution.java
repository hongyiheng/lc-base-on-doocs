class Solution {
    public long minimumRemoval(int[] beans) {
        Arrays.sort(beans);
        int n = beans.length;
        long s = 0;
        for (int v : beans) {
            s += v;
        }
        long ans = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            long t = s - 1L * (n - i) * beans[i];
            ans = Math.min(ans, t);
        }
        return ans;
    }
}