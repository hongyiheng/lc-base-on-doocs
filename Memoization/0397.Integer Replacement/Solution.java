class Solution {
    Map<Long, Long> mp = new HashMap<>();

    public int integerReplacement(int n) {
        return (int) dfs((long) n);
    }

    public long dfs(long n) {
        if (n == 1) {
            return 0;
        }
        if (n % 2 == 0) {
            long ans = 0;
            if (!mp.containsKey(n / 2)) {
                ans = dfs(n / 2);
                mp.put(n / 2, ans);
            } else {
                ans = mp.get(n / 2);
            }
            return 1 + ans;
        } else {
            long ans1 = 0, ans2 = 0;
            if (!mp.containsKey(n + 1)) {
                ans1 = dfs(n + 1);
                mp.put(n + 1, ans1);
            } else {
                ans1 = mp.get(n + 1);
            }
            if (!mp.containsKey(n - 1)) {
                ans2 = dfs(n - 1);
                mp.put(n - 1, ans2);
            } else {
                ans2 = mp.get(n - 1);
            }
            return 1 + Math.min(ans1, ans2);
        }
    }
}