class Solution {
    public int minimumLevels(int[] possible) {
        int n = possible.length, s = 0;
        for (int i = 1; i < n; i++) {
            s += possible[i] == 0 ? -1 : 1;
        }
        int t = possible[0] == 0 ? -1 : 1;
        for (int i = 1; i < n - 1; i++) {
            if (t > s) {
                return i;
            }
            t += possible[i] == 0 ? -1 : 1;
            s -= possible[i] == 0 ? -1 : 1;
        }
        return t > s ? n - 1 : -1;
    }
}