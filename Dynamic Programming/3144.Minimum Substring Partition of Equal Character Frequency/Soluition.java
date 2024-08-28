class Solution {
    int n;
    int[] f;

     private int dfs(String s, int i) {
        if (i >= n) {
            return 0;
        }
        if (f[i] != -1) {
            return f[i];
        }
        int ans = Integer.MAX_VALUE;
        Map<Character, Integer> cnt = new HashMap<>();
        int mx = 0;
        for (int j = i; j < n; j++) {
            cnt.put(s.charAt(j), cnt.getOrDefault(s.charAt(j), 0) + 1);
            mx = Math.max(mx, cnt.get(s.charAt(j)));
            if (j - i + 1 == mx * cnt.size()) {
                ans = Math.min(ans, dfs(s, j + 1) + 1);
            }
        }
        f[i] = ans;
        return ans;
    }

    public int minimumSubstringsInPartition(String s) {
        n = s.length();
        f = new int[n];
        Arrays.fill(f, -1);
        return dfs(s, 0);
    }
}