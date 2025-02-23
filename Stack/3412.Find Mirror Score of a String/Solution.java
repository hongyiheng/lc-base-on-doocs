class Solution {
    public long calculateScore(String s) {
        Deque<Integer>[] idx = new Deque[26];
        for (int i = 0; i < 26; i++) {
            idx[i] = new ArrayDeque<>();
        }
        long ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int v = s.charAt(i) - 'a';
            int t = 25 - v;
            if (!idx[t].isEmpty()) {
                ans += i - idx[t].pollLast();
            } else {
                idx[v].addLast(i);
            }
        }
        return ans;
    }
}