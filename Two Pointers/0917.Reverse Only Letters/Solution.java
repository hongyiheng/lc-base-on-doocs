class Solution {
    public String reverseOnlyLetters(String s) {
        char[] ans = s.toCharArray();
        int l = 0, r = s.length() - 1;
        while (l < r) {
            while (l < s.length() && !Character.isLetter(ans[l])) {
                l++;
            }
            while (r >= 0 && !Character.isLetter(ans[r])) {
                r--;
            }
            if (l >= r || l >= s.length() || r < 0) {
                break;
            }
            char tmp = ans[l];
            ans[l] = ans[r];
            ans[r] = tmp;
            l++;
            r--;
        }
        return new String(ans);
    }
}