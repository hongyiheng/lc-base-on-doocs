class Solution {
    public long flowerGame(int n, int m) {
        return n / 2 * (m - m / 2) + m / 2 * (n - n / 2);
    }
}