class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int n = name.length(), m = typed.length();
        if (n > m) {
            return false;
        }
        int i = 0, j = 0;
        while (j < m) {
            if (i < n && name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                j++;
            } else {
                return false;
            }
        }
        return i == n && j == m;
    }
}