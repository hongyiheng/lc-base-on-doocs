class Solution {
    public String reverseStr(String s, int k) {
        int n = s.length();
        char[] ans = s.toCharArray();
        for (int i = 0; i < n; i+= k) {
            if (i / k % 2 == 0) {
                int l = i, r = Math.min(n - 1, i + k - 1);
                while (l < r) {
                    char t = ans[l];
                    ans[l] = ans[r];
                    ans[r] = t;
                    l++;
                    r--;
                }
            }
        }
        return new String(ans);
    }
}