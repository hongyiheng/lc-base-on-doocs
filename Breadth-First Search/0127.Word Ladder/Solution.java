class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int n = wordList.size();
        boolean[] used = new boolean[n];
        Deque<String> q = new ArrayDeque<>();
        q.add(beginWord);
        int ans = 1;
        while (!q.isEmpty()) {
            int m = q.size();
            for (int i = 0; i < m; i++) {
                String cur = q.pollFirst();
                for (int j = 0; j < n; j++) {
                    if (used[j]) {
                        continue;
                    }
                    String ne = wordList.get(j);
                    if (!checkNext(cur, ne)) {
                        continue;
                    }
                    if (ne.equals(endWord)) {
                        return ans + 1;
                    }
                    q.addLast(ne);
                    used[j] = true;
                }
            }
            ans++;
        }
        return 0;
    }

    public boolean checkNext(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
            }
            if (diff > 1) {
                break;
            }
        }
        return diff == 1;
    }


}