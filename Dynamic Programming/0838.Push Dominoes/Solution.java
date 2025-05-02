public class Solution {

    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        char[] ans = dominoes.toCharArray();
        Deque<Pair<Integer, Character>> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            char c = dominoes.charAt(i);
            if (c != '.') {
                q.offer(new Pair<>(i, c));
            }
        }
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Pair<Integer, Character> item = q.poll();
                int pos = item.getKey();
                char c = item.getValue();
                if (c == 'L' && pos > 0 && dominoes.charAt(pos - 1) == '.') {
                    if (pos > 1 && dominoes.charAt(pos - 2) == 'R') {
                        continue;
                    }
                    ans[pos - 1] = 'L';
                    q.offer(new Pair<>(pos - 1, 'L'));
                }
                if (c == 'R' && pos < n - 1 && dominoes.charAt(pos + 1) == '.') {
                    if (pos + 2 < n && dominoes.charAt(pos + 2) == 'L') {
                        continue;
                    } 
                    ans[pos + 1] = 'R';
                    q.offer(new Pair<>(pos + 1, 'R'));
                }
            }
            dominoes = new String(ans);
        }
        return new String(ans);
    }
}
