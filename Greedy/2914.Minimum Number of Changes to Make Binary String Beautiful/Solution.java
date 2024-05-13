
class Solution {
    public int minChanges(String s) {
        int ans = 0, cnt = 0;
        char cur = s.charAt(0);
        for (char c : s.toCharArray()) {
            if (c != cur) {
                if (cnt == 1) {
                    cnt ^= 1;
                    ans++;
                } else {
                    cnt = 1;
                    cur = c;
                }
            } else {
                cnt ^= 1;
            }
        }
        return cnt == 1 ? ans + 1 : ans;
    }
}