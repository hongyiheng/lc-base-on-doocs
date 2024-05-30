class Solution {

    public boolean check(String s, int x) {
        int[] cnt = new int[26];
        int i = 0;
        while (i < s.length()) {
            int j = i + 1;
            while (j < s.length() && s.charAt(i) == s.charAt(j)) {
                j++;
            }
            int v = s.charAt(i) - 'a';
            cnt[v] += Math.max(0, x != 0 ? j - i - x + 1 : j - i - x);
            if (cnt[v] >= 3) {
                return true;
            }
            i = j;
        }
        return false;
    }

    public int maximumLength(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (check(s, mid)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return check(s, r) ? r : -1;
    }
}