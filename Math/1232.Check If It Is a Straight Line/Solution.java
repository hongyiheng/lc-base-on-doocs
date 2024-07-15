class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        for (int i = 2; i < coordinates.length; i++) {
            int lx = coordinates[i - 2][0], ly = coordinates[i - 2][1];
            int x = coordinates[i - 1][0], y = coordinates[i - 1][1];
            int nx = coordinates[i][0], ny = coordinates[i][1];
            if ((x - lx) * (ny - ly) != (y - ly) * (nx - lx)) {
                return false;
            }
        }
        return true;
    }
}