class Solution {
    public int heightChecker(int[] heights) {
        int ans = 0;
        int[] cnt = new int[101];
        for (int v : heights) {
            cnt[v]++;
        }
        int idx = 1;
        for (int v : heights) {
            while (cnt[idx] == 0) {
                idx++;
            }
            if (idx != v) {
                ans++;
            }
            cnt[idx]--;
        }
        return ans;
    }
}