class Solution {
    public int prefixCount(String[] words, String pref) {
        int ans = 0;
        for (String w : words) {
            if (w.length() < pref.length()) {
                continue;
            }
            boolean flag = true;
            for (int i = 0; i < pref.length(); i++) {
                if (pref.charAt(i) != w.charAt(i)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans++;
            }
        }
        return ans;
    }
}