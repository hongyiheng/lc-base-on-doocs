class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int x = m, y = n;
        for (int[] e : ops) {
            x = Math.min(e[0], x);
            y = Math.min(e[1], y);
        }
        return x * y;
    }
}