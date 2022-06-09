class Solution {
    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        Arrays.sort(tiles, (a, b) -> a[0] - b[0]);
        int l = 0, r = 0, n = tiles.length;
        int cur = 0, ans = 0;
        while (l <= r && r < n) {
            int left = tiles[l][0], right = tiles[l][0] + carpetLen - 1;
            if (tiles[r][1] <= right) {
                cur += tiles[r][1] - tiles[r][0] + 1;
                ans = Math.max(ans, cur);
                r++;
            } else {
                if (tiles[r][0] <= right) {
                    ans = Math.max(ans, cur + right - tiles[r][0] + 1);
                }
                cur -= tiles[l][1] - tiles[l][0] + 1;
                l++;
            }
        }
        return ans;
    }
}