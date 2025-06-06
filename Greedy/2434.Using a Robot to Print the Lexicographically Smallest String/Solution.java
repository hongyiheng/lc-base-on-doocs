class Solution {
    int[] cnt;

    public String robotWithString(String s) {
        cnt = new int[26];
        char[] cs = s.toCharArray();
        for (char c : cs) {
            cnt[c - 'a']++;
        }
        Deque<Character> q = new ArrayDeque<>();
        StringBuilder ans = new StringBuilder();
        for (char c : cs) {
            cnt[c - 'a']--;
            q.addLast(c);
            while (!q.isEmpty() && isMin(q.peekLast())) {
                ans.append(String.valueOf(q.pollLast()));
            }
        }
        while (!q.isEmpty()) {
            ans.append(String.valueOf(q.pollLast()));
        }
        return ans.toString();
    }

    public boolean isMin(char c) {
        int idx = c - 'a';
        for (int i = idx - 1; i >= 0; i--) {
            if (cnt[i] > 0) {
                return false;
            }
        }
        return true;
    }
}