class Solution {
    public int scoreOfString(String s) {
        int ans = 0;
        char last = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            char v = s.charAt(i);
            ans += Math.abs(last - v);
            last = v;
        }
        return ans;
    }
}