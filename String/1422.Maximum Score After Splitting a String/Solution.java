class Solution {
    public int maxScore(String s) {
        int n = s.length(), one = 0;
        int[] zero = new int[n];
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                zero[i] = zero[i - 1];
            }
            if (s.charAt(i) == '0') {
                zero[i]++;
            } else {
                one++;
            }
        }
        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            int left = zero[i], right = one - (i + 1 - zero[i]);
            ans = Math.max(ans, left + right);
        }
        return ans;
    }
}