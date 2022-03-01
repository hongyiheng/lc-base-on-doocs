class Solution {
    public String convert(String s, int numRows) {
        int n = s.length();
        if (n <= numRows || numRows == 1) {
            return s;
        }
        int t = (n + numRows - 1) / numRows;
        int c = (t - 1) * (numRows - 2) + t;
        String[][] ans = new String[numRows][c];
        int[][] dirs = new int[][]{{1, 0}, {-1, 1}};
        int x = 0, y = 0, d = 1, index = 0;
        while (index < n) {
            ans[x][y] = String.valueOf(s.charAt(index++));
            if (x == numRows - 1 || x == 0) {
                d = d == 1 ? 0 : 1;
            }
            x += dirs[d][0];
            y += dirs[d][1];
        }
        StringBuilder sb = new StringBuilder();
        for (String[] row : ans) {
            for (String ch : row) {
                if (!"".equals(ch) && ch != null) {
                    sb.append(ch);
                }
            }
        }
        return sb.toString();
    }
}