class Solution {
    public int captureForts(int[] forts) {
        int i = 0, n = forts.length;
        int ans = 0;
        while (i < n) {
            if (forts[i] != 0) {
                int t = -forts[i], cnt = 0;
                while (i + 1 < n && forts[i + 1] == 0) {
                    cnt++;
                    i++;
                }
                if (i + 1 < n && forts[i + 1] == t) {
                    ans = Math.max(cnt, ans);
                }
            }
            i++;
        }
        return ans;
    }
}