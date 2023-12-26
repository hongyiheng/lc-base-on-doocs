class Solution {

    Set<Integer> masks;
    int m, n;

    public void dfs(int i, int mask) {
        if (i == n) {
            masks.add(mask);
            return;
        }
        if (i == 0 || (mask >> (i - 1) & 1) == 0) {
            dfs(i + 1, mask | 1 << i);
        }
        dfs(i + 1, mask);
    }

    public boolean check(int u, int v) {
        for (int i = 0; i < n; i++) {
            if ((v >> i & 1) == 0) {
                continue;
            }
            if (i > 0 && (u >> (i - 1) & 1) == 1) {
                return false;
            }
            if (i < n - 1 && (u >> (i + 1) & 1) == 1) {
                return false;
            }
        }
        return true;
    }

    public int getVal(char[][] seats, int i, int mask) {
        int ans = 0;
        for (int j = 0; j < n; j++) {
            if (seats[i][j] == '.' && (mask >> j & 1) == 1) {
                ans++;
            }
        }
        return ans;
    }

    public int maxStudents(char[][] seats) {
        m = seats.length;
        n = seats[0].length;
        masks = new HashSet<>();
        dfs(0, 0);
        Map<Integer, Set<Integer>> g = new HashMap<>();
        for (int u : masks) {
            for (int v : masks) {
                if (check(u, v)) {
                    g.computeIfAbsent(v, k -> new HashSet<>()).add(u);
                }
            }
        }
        Map<String, Integer> f = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int v : masks) {
                int w = getVal(seats, i, v);
                for (int u : g.getOrDefault(v, new HashSet<>())) {
                    f.put(i + ":" + v, Math.max(f.getOrDefault(i + ":" + v, 0), f.getOrDefault(i - 1 + ":" + u, 0) + w));
                }
            }
        }
        int ans = 0;
        for (int mask : masks) {
            ans = Math.max(ans, f.get(m - 1 + ":" + mask));
        }
        return ans;
    }
}