class Solution {
    public String largestGoodInteger(String num) {
        int cnt = 0, ans = -1;
        char cur = ' ';
        for (char c : num.toCharArray()) {
            if (cur != c) {
                cnt = 1;
                cur = c;
            } else {
                cnt++;
            }
            if (cnt == 3) {
                ans = Math.max(c - '0', ans);
            }
        }
        return ans == -1 ? "" : "" + ans + ans + ans;
    }
}