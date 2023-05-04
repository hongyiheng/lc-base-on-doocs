class Solution {
    public String firstPalindrome(String[] words) {
        for (String w : words) {
            int l = 0, r = w.length() - 1;
            while (l < r) {
                if (w.charAt(l) != w.charAt(r)) {
                    break;
                }
                l++;
                r--;
            }
            if (l >= r) {
                return w;
            }
        }
        return "";
    }
}
