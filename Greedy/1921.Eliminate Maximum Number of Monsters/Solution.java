class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        int[] t = new int[n];
        for (int i = 0; i < n; i++) {
            t[i] = Math.max((dist[i] + speed[i] - 1) / speed[i], 1);
        }
        Arrays.sort(t);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (t[i] <= i) {
                break;
            }
            ans++;
        }
        return ans;
    }
}