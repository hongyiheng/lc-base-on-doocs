class Solution {
    public long maximumSubsequenceCount(String text, String pattern) {
        char a = pattern.charAt(0), b = pattern.charAt(1);
        if (a == b) {
            long cnt = 0;
            for (char c : text.toCharArray()) {
                if (c == a) {
                    cnt++;
                }
            }
            return (cnt + 1) * cnt / 2;
        }
        long cntA = 0, cntB = 0, ans = 0;
        for (char c : text.toCharArray()) {
            if (c == a) {
                cntA++;
            } else if (c == b) {
                cntB++;
                ans += cntA;
            }
        }
        ans += Math.max(cntA, cntB);
        return ans;
    }
}