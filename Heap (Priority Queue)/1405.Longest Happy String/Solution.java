class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        if (a > 0) {
            q.add(new int[]{0, a});
        }
        if (b > 0) {
            q.add(new int[]{1, b});
        }
        if (c > 0) {
            q.add(new int[]{2, c});
        }
        String ans = "";
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int n = ans.length();
            if (n >= 2 && ans.charAt(n - 1) - 'a' == cur[0] && ans.charAt(n - 2) - 'a' == cur[0]) {
                if (!q.isEmpty()) {
                    int[] next = q.poll();
                    ans += (char)('a' + next[0]);
                    if (--next[1] > 0) {
                        q.add(next);
                    }
                    q.add(cur);
                }
            } else {
                ans += (char)('a' + cur[0]);
                if (--cur[1] > 0) {
                    q.add(cur);
                }
            }
        }
        return ans;
    }
}