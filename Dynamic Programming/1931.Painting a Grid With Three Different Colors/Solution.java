class Solution {

    List<String> masks;

    public void dfs(List<String> path, int m) {
        if (path.size() == m) {
            masks.add(String.join("", path));
            return;
        }
        for (String k : new String[]{"0", "1", "2"}) {
            if (!path.isEmpty() && path.get(path.size() - 1).equals(k)) {
                continue;
            }
            path.add(k);
            dfs(path, m);
            path.remove(path.size() - 1);
        }
    }

    public int colorTheGrid(int m, int n) {
        masks = new ArrayList<>();
        dfs(new ArrayList<>(), m);

        Map<Integer, Set<Integer>> g = new HashMap<>();
        for (int i = 0; i < masks.size(); i++) {
            for (int j = i + 1; j < masks.size(); j++) {
                boolean diff = true;
                for (int k = 0; k < m; k++) {
                    if (masks.get(i).charAt(k) == masks.get(j).charAt(k)) {
                        diff = false;
                        break;
                    }
                }
                if (diff) {
                    g.computeIfAbsent(i, k -> new HashSet<>()).add(j);
                    g.computeIfAbsent(j, k -> new HashSet<>()).add(i);
                }
            }
        }

        int[][] f = new int[n][masks.size()];
        Arrays.fill(f[0], 1);
        int M = (int) (1e9 + 7);
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < masks.size(); j++) {
                for (int k : g.get(j)) {
                    f[i + 1][k] = (f[i + 1][k] + f[i][j]) % M;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < masks.size(); i++) {
            ans = (ans + f[n - 1][i]) % M;
        }
        return ans;
    }
}