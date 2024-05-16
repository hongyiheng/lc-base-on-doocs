class Solution {
    public String getSmallestString(String s, int k) {
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            int d = cs[i] - 'a';
            d = Math.min(d, 26 - d);
            if (k >= d) {
                cs[i] = 'a';
                k -= d;
            } else {
                cs[i] = (char)(cs[i] - k);
                break;
            }
        }
        return new String(cs);
    }
}