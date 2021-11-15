class Solution {
    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        char[] chars = moves.toCharArray();
        for (char c : chars) {
            if (c == 'U') {
                y++;
            } else if (c == 'D') {
                y--;
            } else if (c == 'R') {
                x++;
            } else if (c == 'L') {
                x--;
            }
        }
        return x == 0 && y == 0;
    }
}