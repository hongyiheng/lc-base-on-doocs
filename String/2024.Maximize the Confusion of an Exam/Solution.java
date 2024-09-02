class Solution {
    public int f(String answerKey, char t, int k) {
        int n = answerKey.length();
        int l = 0, r = 0;
        int ans = 0, d = 0;
        while (r < n) {
            char c = answerKey.charAt(r);
            if (c != t) {
                d++;
            }
            while (d > k) {
                if (answerKey.charAt(l++) != t) {
                    d--;
                }
            }
            ans = Math.max(ans, r - l + 1);
            r++;
        }
        return ans;
    }

    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(f(answerKey, 'T', k), f(answerKey, 'F', k));
    }
}