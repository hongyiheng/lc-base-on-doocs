class Solution {
    Set<Integer> row;
    Set<Integer> col;
    char[][] picture;
    int ans = 0;
    public int findLonelyPixel(char[][] picture) {
        this.picture = picture;
        row = new HashSet<>();
        col = new HashSet<>();
        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[0].length; j++) {
                if (picture[i][j] == 'B') {
                    check(i, j);
                }
            }
        }
        return ans;
    }

    public void check(int x, int y) {
        if (row.contains(x) || col.contains(y)) {
            return;
        }
        row.add(x);
        col.add(y);
        for (int i = 0; i < picture.length; i++) {
            if (i == x) {
                continue;
            }
            if (picture[i][y] == 'B') {
                return;
            }
        }
        for (int j = 0; j < picture[0].length; j++) {
            if (j == y) {
                continue;
            }
            if (picture[x][j] == 'B') {
                return;
            }
        }
        ans++;
    }
}