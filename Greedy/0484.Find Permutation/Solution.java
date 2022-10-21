class Solution {
    public int[] findPermutation(String s) {
        int n = s.length();
        int[] ans = new int[n + 1];
        for (int i = 1; i <= n + 1; i++) {
            ans[i - 1] = i;
        }
        int idx = 0;
        while (idx < n) {
            if (s.charAt(idx) == 'I') {
                idx++;
            } else {
                int l = idx;
                while (idx < n && s.charAt(idx) == 'D') {
                    idx++;
                }
                int r = idx;
                while (l < r) {
                    int tmp = ans[l];
                    ans[l] = ans[r];
                    ans[r] = tmp;
                    r--;
                    l++;
                }
            }
        }
        return ans;
    }
}
