class Solution {
    public boolean queryString(String s, int n) {
        if (n > 1 << 11) {
            return false;
        }
        for (int i = 1; i <= n; i++) {
            if (!s.contains(Integer.toBinaryString(i))) {
                return false;
            }
        }
        return true;
    }
}
