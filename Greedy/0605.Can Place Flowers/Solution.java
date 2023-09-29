class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int m = flowerbed.length;
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            if (flowerbed[i] != 0) {
                continue;
            }
            if (flowerbed[Math.max(0, i - 1)] == 0 && flowerbed[Math.min(m - 1, i + 1)] == 0) {
                flowerbed[i] = 1;
                cnt++;
            }
        }
        return cnt >= n;
    }
}