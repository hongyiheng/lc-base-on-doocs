class Solution {
    public int findChampion(int n, int[][] edges) {
        int[] to = new int[n];
        for (int[] e : edges) {
            to[e[1]]++;
        }
        int ans = -1;
        for (int i = 0; i < n; i++) {
            if (to[i] != 0) {
                continue;
            }
            if (ans != -1) {
                return -1;
            }
            ans = i;
        }
        return ans;
    }
}