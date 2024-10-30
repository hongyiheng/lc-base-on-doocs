class Solution {
    public String getSmallestString(String s) {
        char[] cs = s.toCharArray();
        for (int i = 1; i < cs.length; i++) {
            int last = cs[i - 1] - '0', v = cs[i] - '0';
            if (last > v && last % 2 == v % 2) {
                char t = cs[i - 1];
                cs[i - 1] = cs[i];
                cs[i] = t;
                break;
            }
        }
        return new String(cs);
    }
}