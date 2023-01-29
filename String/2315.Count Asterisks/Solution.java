class Solution {
    public int countAsterisks(String s) {
        int ans = 0, cur = 0;
        boolean mid = false;
        for (char c : s.toCharArray()) {
            if (c == '*') {
                cur++;
            }
            if (c == '|') {
                if (!mid) {
                    ans += cur;
                }
                mid = !mid;
                cur = 0;
            }
        }
        return ans + cur;
    }
}