class Solution {

    public boolean[] getPrimes(int n) {
        boolean[] primes = new boolean[n];
        for (int i = 2; i < n; i++) {
            if (!primes[i]) {
                for (long j = (long)i * i; j < n; j += i) {
                    primes[(int)j] = true;
                }
            }
        }
        primes[1] = true;
        return primes;
    }

    int[] p;
    int[] size;

    public int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    public void union(int a, int b) {
        int r1 = find(a), r2 = find(b);
        if (r1 != r2) {
            size[r2] += size[r1];
            p[r1] = r2;
        }
    }

    public long countPaths(int n, int[][] edges) {
        boolean[] primes = getPrimes(n + 1);
        p = new int[n + 1];
        size = new int[n + 1];
        Arrays.fill(size, 1);
        for (int i = 1; i <= n; i++) {
            p[i] = i;
        }

        Map<Integer, List<Integer>> g = new HashMap<>();
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            if (primes[u] && primes[v]) {
                union(u, v);
            }
            g.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            g.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        long ans = 0;
        for (int u = 1; u <= n; u++) {
            if (primes[u]) {
                continue;
            }
            long s = 0;
            for (int v : g.getOrDefault(u, new ArrayList<>())) {
                if (!primes[v]) {
                    continue;
                }
                int cnt = size[find(v)];
                System.out.println(u + "," + v + "," + cnt);
                ans += cnt;
                ans += s * cnt;
                s += cnt;
            }
        }
        return ans;
    }
}