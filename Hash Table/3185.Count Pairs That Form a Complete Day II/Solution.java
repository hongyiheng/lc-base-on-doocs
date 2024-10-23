class Solution {
    public long countCompleteDayPairs(int[] hours) {
        int[] cnt = new int[24];
        long ans = 0;
        for (int v : hours) {
            ans += cnt[(24 - v % 24) % 24];
            cnt[v % 24]++;
        }
        return ans;
    }
}