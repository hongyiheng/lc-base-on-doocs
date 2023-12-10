class Solution {
    public long minimumSteps(String s) {
        long ans = 0, cnt = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                cnt++;
            } else {
                ans += cnt;
            }
        }
        return ans;
    }
}