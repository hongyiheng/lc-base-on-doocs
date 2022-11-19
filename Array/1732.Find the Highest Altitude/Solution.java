class Solution {
    public int largestAltitude(int[] gain) {
        int ans = 0, cur = 0;
        for (int v : gain) {
            cur += v;
            ans = Math.max(ans, cur);
        }
        return ans;
    }
}
