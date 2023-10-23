class Solution {
    public int countSeniors(String[] details) {
        int ans = 0;
        for (String v : details) {
            if ((v.charAt(11) - '0') * 10 + (v.charAt(12) - '0') > 60) {
                ans++;
            }
        }
        return ans;
    }
}