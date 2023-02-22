class Solution {

    Map<String, Integer> mp = new HashMap<>();

    int[] tail;

    int n;

    public int stoneGameII(int[] piles) {
        n = piles.length;
        tail = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            tail[i] = tail[i + 1] + piles[i];
        }
        return dfs(0, 1);
    }

    public int dfs(int i, int m) {
        if (i + 2 * m >= n) {
            return tail[i];
        }
        if (mp.containsKey(i + ":" + m)) {
            return mp.get(i + ":" + m);
        }
        int mi = 0x3f3f3f3f;
        for (int x = 1; x <= 2 * m; x++) {
            mi = Math.min(mi, dfs(i + x, Math.max(x, m)));
        }
        mp.put(i + ":" + m, tail[i] - mi);
        return tail[i] - mi;
    }
}
