class Solution {
    int n;
    char[] t;

    public int kSimilarity(String s1, String s2) {
        n = s1.length();
        t = s2.toCharArray();
        Deque<String> q = new ArrayDeque<>();
        q.addLast(s1);
        int ans = 0;
        Set<String> vis = new HashSet<>();
        while (true) {
            int m = q.size();
            for (int i = 0; i < m; i++) {
                String cur = q.pollFirst();
                if (cur.equals(s2)) {
                    return ans;
                }
                if (vis.contains(cur)) {
                    continue;
                }
                for (String ns : next(cur)) {
                    q.addLast(ns);
                }
            }
            ans++;
        }
    }

    public List<String> next(String s) {
        int idx = 0;
        while (s.charAt(idx) == t[idx]) {
            idx++;
        }
        List<String> ans = new ArrayList<>();
        for (int i = idx + 1; i < n; i++) {
            if (s.charAt(i) == t[idx] && s.charAt(i) != t[i]) {
                char[] cs = s.toCharArray();
                char tmp = cs[i];
                cs[i] = cs[idx];
                cs[idx] = tmp;
                ans.add(new String(cs));
            }
        }
        return ans;
    }
}
