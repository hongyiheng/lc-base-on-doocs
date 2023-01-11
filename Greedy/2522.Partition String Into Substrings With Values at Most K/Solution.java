class Solution {
    public int minimumPartition(String s, int k) {
        int ans = 0;
        long cur = 0;
        for (char c : s.toCharArray()) {
            int v = c - '0';
            if (v > k) {
                return -1;
            }
            if (cur * 10 + v > k) {
                cur = v;
                ans++;
            } else {
                cur = cur * 10 + v;
            }
        }
        if (cur != 0) {
            ans++;
        }
        return ans;
    }
}