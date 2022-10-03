class Solution {
    public boolean checkOnesSegment(String s) {
        int ans = 0, n = s.length(), idx = 0;
        while (idx < n) {
            if (s.charAt(idx) == '1') {
                ans++;
                while (idx < n && s.charAt(idx) == '1') {
                    idx++;
                }
            } else {
                idx++;
            }
        }
        return ans <= 1;
    }
}
