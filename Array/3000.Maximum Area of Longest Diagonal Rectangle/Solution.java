class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int mx = 0, ans = 0;
        for (int[] e : dimensions) {
            int h = e[0], w = e[1];
            int v = h * h + w * w, s = h * w;
            if (v > mx || (v == mx && s > ans)) {
                mx = v;
                ans = s;
            }
        }
        return ans;
    }
}