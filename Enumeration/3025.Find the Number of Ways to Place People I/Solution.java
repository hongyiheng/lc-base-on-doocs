class Solution {

    boolean[][] g = new boolean[51][51];

    public boolean check(int[] a, int[] b) {
        int x = a[0], y = a[1];
        int nx = b[0], ny = b[1];
        if (x > nx || y < ny) {
            return false;
        }
        for (int i = x; i <= nx; i++) {
            for (int j = ny; j <= y; j++) {
                if ((i == x && j == y) || (i == nx && j == ny)) {
                    continue;
                }
                if (g[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public int numberOfPairs(int[][] points) {
        for (int[] e : points) {
            g[e[0]][e[1]] = true;
        }
        Arrays.sort(points, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);
        int n = points.length, ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (check(points[i], points[j])) {
                    ans++;
                }
            }
        }
        return ans;
    }
}