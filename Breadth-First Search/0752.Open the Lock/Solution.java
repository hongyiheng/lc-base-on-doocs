class Solution {
    public Set<String> getNext(String s) {
        Set<String> ans = new HashSet<>();
        for (int i = 0; i < 4; i++) {
            int v = s.charAt(i) - '0';
            ans.add(s.substring(0, i) + (v == 9 ? 0 : v + 1) + s.substring(i + 1));
            ans.add(s.substring(0, i) + (v == 0 ? 9 : v - 1) + s.substring(i + 1));
        }
        return ans;
    }

    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>();
        for (String s : deadends) {
            dead.add(s);
        }
        if (dead.contains("0000") || dead.contains(target)) {
            return -1;
        }
        Set<String> vis = new HashSet<>();
        Deque<String> q = new ArrayDeque<>();
        q.addLast("0000");
        vis.add("0000");
        int ans = 0;
        while (!q.isEmpty()) {
            int k = q.size();
            while (k-- > 0) {
                String s = q.pollFirst();
                if (target.equals(s)) {
                    return ans;
                }
                for (String ns : getNext(s)) {
                    if (vis.contains(ns) || dead.contains(ns)) {
                        continue;
                    }
                    q.addLast(ns);
                    vis.add(ns);
                }
            }
            ans++;
        }
        return -1;
    }
}