class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int n = s.length(), m = t.length();
        if (Math.abs(m - n) > 1) {
            return false;
        }
        int i = 0, j = 0, diff = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                diff++;
                if (m == n) {
                    i++;
                    j++;
                } else if (n > m) {
                    i++;
                } else {
                    j++;
                }
            }
        }
        return diff == 1 || (diff == 0 && Math.abs(m - n) == 1);
    }
}
