class Solution {

    public boolean check(int i, int j, int k, int l, int e, int f, int[][] dirs) {
        for (int[] d : dirs) {
            int x = i, y = j;
            while (true) {
                int nx = x + d[0], ny = y + d[1];
                if (nx < 1 || nx > 8 || ny < 1 || ny > 8) {
                    break;
                }
                if (nx == k && ny == l) {
                    break;
                }
                if (nx == e && ny == f) {
                    return true;
                }
                x = nx;
                y = ny;
            }
        }
        return false;
    }


    public int minMovesToCaptureTheQueen(int a, int b, int c, int d, int e, int f) {
        boolean ans1 = check(a, b, c, d, e, f, new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}});
        boolean ans2 = check(c, d, a, b, e, f, new int[][]{{1, 1}, {1, -1}, {-1, 1}, {-1, -1}});
        return ans1 || ans2 ? 1 : 2;
    }
}