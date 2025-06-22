class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        String[] ans = new String[(n + k - 1) / k];
        for (int i = 0; i < n; i += k) {
            String v = s.substring(i, Math.min(i + k, n));
            while (v.length() < k) {
                v += fill;
            }
            ans[i / k] = v;
        }
        return ans;
    }
}