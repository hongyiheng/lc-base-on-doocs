class Solution {
    public int minFlipsMonoIncr(String s) {
        int ans = 0, cnt = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                cnt++;
            } else {
                ans = Math.min(ans + 1, cnt);
            }
        }
        return ans;
    }
}