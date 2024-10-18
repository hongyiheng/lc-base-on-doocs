class Solution {
    public int minChanges(int n, int k) {
        int ans = 0;
        for (int i = 0; i < 31; i++) {
            if ((n >> i & 1) != 0 && (k >> i & 1) == 0) {
                ans++;
            }
            if ((n >> i & 1) == 0 && (k >> i & 1) == 1) {
                return -1;
            }
        }
        return ans;
    }
}