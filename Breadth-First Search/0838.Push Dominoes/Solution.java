class Solution {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        char[] ans = dominoes.toCharArray();
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (ans[i] == 'L' || ans[i] == 'R') {
                q.addLast(i);
            }
        }
        while (!q.isEmpty()) {
            int m = q.size();
            for (int k = 0; k < m; k++) {
                int i = q.pollFirst();
                char cur = ans[i];
                if (cur == 'L' && i > 0 && dominoes.charAt(i - 1) == '.') {
                    if (i > 1 && dominoes.charAt(i - 2) == 'R') {
                        continue;
                    }
                    ans[i - 1] = cur;
                    q.addLast(i - 1);
                }
                if (cur == 'R' && i < n - 1 && dominoes.charAt(i + 1) == '.') {
                    if (i < n - 2 && dominoes.charAt(i + 2) == 'L') {
                        continue;
                    }
                    ans[i + 1] = cur;
                    q.addLast(i + 1);
                }
            }
            dominoes = new String(ans);
        }
        return new String(ans);
    }
}