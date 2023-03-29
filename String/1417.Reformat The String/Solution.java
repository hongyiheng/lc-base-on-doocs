class Solution {
    public String reformat(String s) {
        Deque<Character> q1 = new ArrayDeque<>(), q2 = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if ('0' <= c && c <= '9') {
                q1.addLast(c);
            } else {
                q2.addLast(c);
            }
        }
        if (Math.abs(q1.size() - q2.size()) > 1) {
            return "";
        }
        int n = s.length();
        char[] ans = new char[n];
        ans[0] = q1.size() > q2.size() ? q1.poll() : q2.poll();
        for (int i = 1; i < n; i++) {
            if ('0' <= ans[i - 1] && ans[i - 1] <= '9') {
                ans[i] = q2.poll();
            } else {
                ans[i] = q1.poll();
            }
        }
        return new String(ans);
    }
}