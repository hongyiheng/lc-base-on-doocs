class Solution {
    public int minOperations(int n) {
        int M = 20;
        boolean[] q = new boolean[M];
        for (int i = 0; i < M; i++) {
            q[i] = (n >> i & 1) == 1;
        }
        int ans = 0, l = 0;
        while (l < M) {
            if (!q[l]) {
                l++;
                continue;
            }
            int r = l;
            while (r < M && q[r + 1]) {
                r++;
            }
            if (l < r) {
                q[r + 1] = true;
            }
            ans++;
            l = r + 1;
        }
        return ans;
    }
}