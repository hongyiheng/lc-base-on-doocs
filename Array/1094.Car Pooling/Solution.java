class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] q = new int[1010];
        for (int[] t : trips) {
            int n = t[0], u = t[1], v = t[2];
            q[u] += n;
            q[v] -= n;
        }
        int s = 0;
        for (int v : q) {
            s += v;
            if (s > capacity) {
                return false;
            }
        }
        return true;
    }
}