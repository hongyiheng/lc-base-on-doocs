class Solution {
    public int minOperations(String s) {
        int ans1 = 0, ans2 = 0;
        char cur = '0';
        for (char c : s.toCharArray()) {
            if (cur == c) {
                ans1++;
            } else {
                ans2++;
            }
            cur = cur == '0' ? '1' : '0';
        }
        return Math.min(ans1, ans2);
    }
}
