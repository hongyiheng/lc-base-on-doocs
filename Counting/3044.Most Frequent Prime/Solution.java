class Solution {

    public boolean isPrime(int x) {
        for (int i = 2; i <= (int)Math.sqrt(x); i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int mostFrequentPrime(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        Map<Integer, Integer> g = new HashMap<>();
        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int[] d : dirs) {
                    int v = mat[i][j], x = i, y = j;
                    while (true) {
                        int nx = x + d[0], ny = y + d[1];
                        if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                            break;
                        }
                        v = v * 10 + mat[nx][ny];
                        g.put(v, g.getOrDefault(v, 0) + 1);
                        x = nx;
                        y = ny;
                    }
                }
            }
        }
        List<int[]> q = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : g.entrySet()) {
            q.add(new int[]{e.getKey(), e.getValue()});
        }
        Collections.sort(q, (a, b) -> a[1] != b[1] ? b[1] - a[1] : b[0] - a[0]);
        for (int[] e : q) {
            if (isPrime(e[0])) {
                return e[0];
            }
        }
        return -1;
    }
}