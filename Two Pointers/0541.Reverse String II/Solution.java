class Solution {
    public String reverseStr(String s, int k) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        for (int i = 0; i < n; i += 2 * k) {
            int l = i, r = Math.min(i + k - 1, n - 1);
            while (l < r) {
                char t = cs[l];
                cs[l] = cs[r];
                cs[r] = t;
                l++;
                r--;
            }
        }
        return new String(cs);
    }
}
