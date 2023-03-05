class Solution {
    public int[] divisibilityArray(String word, int m) {
        int n = word.length();
        int[] ans = new int[n];
        long cur = 0;
        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);
            cur = (cur * 10 + c - '0') % m;
            ans[i] = cur == 0 ? 1 : 0;
        }
        return ans;
    }
}