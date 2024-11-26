class Solution {
    public int numberOfAlternatingGroups(int[] colors) {
        int n = colors.length;
        int ans = colors[n - 1] == colors[1] && colors[1] != colors[0] ? 1 : 0;
        ans += colors[0] == colors[n - 2] && colors[n - 1] != colors[0] ? 1 : 0;
        for (int i = 1; i < n - 1; i++) {
            if (colors[i - 1] == colors[i + 1] && colors[i - 1] != colors[i]) {
                ans++;
            }
        }
        return ans;
    }
}