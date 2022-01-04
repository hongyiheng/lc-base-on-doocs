class Solution {
    public String modifyString(String s) {
        char[] mp = new char[]{'a', 'b', 'c'};
        char[] chars = s.toCharArray();
        int n = chars.length;
        for (int i = 0; i < n; i++) {
            if (chars[i] == '?') {
                for (char v : mp) {
                    if ((i > 0 && v == chars[i - 1]) || (i < n - 1 && v == chars[i + 1])) {
                        continue;
                    }
                    chars[i] = v;
                }
            }
        }
        return new String(chars);
    }
}