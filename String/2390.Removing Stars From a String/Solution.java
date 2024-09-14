class Solution {
    public String removeStars(String s) {
        String ans = "";
        int cnt = 0;
        for (int i = s.length() - 1; i > -1; i--) {
            if (s.charAt(i) == '*') {
                cnt++;
            } else {
                if (cnt == 0) {
                    ans = s.charAt(i) + ans;
                } else {
                    cnt--;
                }
            }
        }
        return ans;
    }
}