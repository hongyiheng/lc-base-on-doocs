class Solution {
    public String alphabetBoardPath(String target) {
        int m = 5, x = 0, y = 0;
        StringBuilder ans = new StringBuilder();
        for (char c : target.toCharArray()) {
            int v = c - 'a';
            int nx = v / m, ny = v % m;
            if (x > nx) {
                for (int i = 0; i < x - nx; i++) {
                    ans.append('U');
                }
            }
            if (y > ny) {
                for (int i = 0; i < y - ny; i++) {
                    ans.append('L');
                }
            }
            if (x < nx) {
                for (int i = 0; i < nx - x; i++) {
                    ans.append('D');
                }
            }
            if (y < ny) {
                for (int i = 0; i < ny - y; i++) {
                    ans.append('R');
                }
            }
            ans.append('!');
            x = nx;
            y = ny;
        }
        return ans.toString();
    }
}