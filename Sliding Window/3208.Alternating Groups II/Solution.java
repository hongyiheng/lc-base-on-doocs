class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int ans = 0, cnt = 1;
        for (int i = 1; i < n * 2; i++) {
            if (colors[i % n] == colors[(i - 1) % n]) {
                cnt = 0;
            }
            if (++cnt >= k && i >= n) {
                ans++;
            }
        }
        return ans;
    }
}