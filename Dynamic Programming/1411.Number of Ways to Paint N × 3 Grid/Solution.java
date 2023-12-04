class Solution {
    public int numOfWays(int n) {
        int M = (int)1e9 + 7;
        // 三色 f1, 双色 f2
        long f1 = 6L, f2 = 6L;
        for (int i = 1; i < n; i++) {
            // 每个三色的下一行, 有 2 个三色, 2 个双色
            // 每个双色的下一行, 有 2 个三色, 3 个双色
            long nf1 = f1 * 2 + f2 * 2;
            long nf2 = f1 * 2 + f2 * 3;
            f1 = nf1 % M;
            f2 = nf2 % M;
        }
        return (int)((f1 + f2) % M);
    }
}



class Solution {

    List<String> masks;

    public void dfs(List<String> path) {
        if (path.size() == 3) {
            masks.add(String.join("", path));
            return;
        }
        for (String s : new String[]{"0", "1", "2"}) {
            if (!path.isEmpty() && path.get(path.size() - 1).equals(s)) {
                continue;
            }
            path.add(s);
            dfs(path);
            path.remove(path.size() - 1);
        }
    }

    public int numOfWays(int n) {
        masks = new ArrayList<>();
        dfs(new ArrayList<>());

        Map<Integer, Set<Integer>> g = new HashMap<>();
        for (int i = 0; i < masks.size(); i++) {
            for (int j = 0; j < masks.size(); j++) {
                boolean diff = false;
                for (int k = 0; k < 3; k++) {
                    if (masks.get(i).charAt(k) == masks.get(j).charAt(k)) {
                        diff = true;
                        break;
                    }
                }
                if (!diff) {
                    g.computeIfAbsent(i, k -> new HashSet<>()).add(j);
                    g.computeIfAbsent(j, k -> new HashSet<>()).add(i);
                }
            }
        }

        int M = (int) (1e9 + 7);
        long[][] f = new long[n][masks.size()];
        Arrays.fill(f[0], 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < masks.size(); j++) {
                for (int k : g.getOrDefault(j, new HashSet<>())) {
                    f[i][j] = (f[i][j] + f[i - 1][k]) % M;
                }
            }
        }
        return (int) (Arrays.stream(f[n - 1]).sum() % M);
    }
}