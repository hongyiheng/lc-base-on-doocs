class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < 26; i++) {
            if (cnt[i] == 0) {
                continue;
            }
            q.offer(new int[]{i, cnt[i]});
        }
        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            int[] a = q.poll();
            if (!ans.isEmpty() && ans.get(ans.size() - 1) == a[0]) {
                if (q.isEmpty()) {
                    break;
                }
                int[] b = q.poll();
                ans.add(b[0]);
                if (--b[1] > 0) {
                    q.offer(b);
                }
                q.offer(a);
            } else {
                int t = Math.min(a[1], repeatLimit);
                for (int i = 0; i < t; i++) {
                    ans.add(a[0]);
                }
                a[1] -= t;
                if (a[1] > 0) {
                    q.offer(a);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i : ans) {
            sb.append((char) (i + 'a'));
        }
        return sb.toString();
    }
}