class Solution {
    public int longestAwesome(String s) {
        int n = s.length();
        int[] pos = new int[1 << 10];
        Arrays.fill(pos, n);
        pos[0] = -1;
        int ans = 0, pre = 0;
        for (int i = 0; i < n; i++) {
            int v = s.charAt(i) - '0';
            pre ^= 1 << v;
            ans = Math.max(ans, i - pos[pre]);
            for (int j = 0; j < 10; j++) {
                ans = Math.max(ans, i - pos[pre ^ (1 << j)]);
            }
            if (pos[pre] == n) {
                pos[pre] = i;
            }
        }
        return ans;
    }
}