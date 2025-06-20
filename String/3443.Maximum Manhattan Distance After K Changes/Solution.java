class Solution {

    public int f(String s, char a, char b, int k) {
        int ans = 0, cur = 0, cnt = 0;
        for (char c : s.toCharArray()) {
            if (c == a || c == b) {
                cur++;
            } else if (cnt < k) {
                cur++;
                cnt++;
            } else {
                cur--;
            }
            ans = Math.max(ans, cur);
        }
        return ans;
    }

    public int maxDistance(String s, int k) {
        return Math.max(Math.max(f(s, 'N', 'E', k), f(s, 'N', 'W', k)), Math.max(f(s, 'S', 'E', k), f(s, 'S', 'W', k)));
    }
}