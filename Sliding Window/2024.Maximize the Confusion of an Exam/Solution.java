class Solution {
    int n, k;
    String s;

    public int maxConsecutiveAnswers(String answerKey, int k) {
        n = answerKey.length();
        this.k = k;
        s = answerKey;
        return Math.max(getCnt('F'), getCnt('T'));
    }

    public int getCnt(char c) {
        int left = 0, right = 0;
        int cnt = 0, ans = 0;
        while (left <= right && right < n) {
            if (s.charAt(right) != c) {
                cnt++;
            }
            while (cnt > k) {
                if (s.charAt(left++) != c) {
                    cnt--;
                }
            }
            right++;
            ans = Math.max(ans, right - left);
        }
        return ans;
    }
}