class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int[] cost = new int[n];
        for (int i = 0; i < n; i++) {
            cost[i] = Math.abs(t.charAt(i) - s.charAt(i));
        }
        int l = 0, r = 0, cur = 0, ans = 0;
        while (r < n) {
            cur += cost[r];
            while (cur > maxCost) {
                cur -= cost[l++];
            }
            ans = Math.max(ans, r - l + 1);
            r++;
        }
        return ans;
    }
}