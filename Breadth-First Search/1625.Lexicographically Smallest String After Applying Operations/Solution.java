class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        Deque<String> q = new ArrayDeque<>();
        Set<String> vis = new HashSet<>();
        q.addLast(s);
        vis.add(s);
        String ans = s;
        while (!q.isEmpty()) {
            String cur = q.removeFirst();
            if (cur.compareTo(ans) < 0) {
                ans = cur;
            }
            char[] cs = cur.toCharArray();
            for (int i = 1; i < cs.length; i += 2) {
                cs[i] = (char) ((cs[i] - '0' + a) % 10 + '0');
            }
            String t1 = new String(cs);
            if (!vis.contains(t1)) {
                vis.add(t1);
                q.addLast(t1);
            }
            String t2 = cur.substring(cur.length() - b) + cur.substring(0, cur.length() - b);
            if (!vis.contains(t2)) {
                vis.add(t2);
                q.addLast(t2);
            }
        }
        return ans;
    }
}