class Solution {

    Set<String> d = new HashSet<>();
    Map<Integer, Integer> g = new HashMap<>();

    public int dfs(String s, int i) {
        if (i == 0) {
            return 0;
        }
        if (g.containsKey(i)) {
            return g.get(i);
        }
        int ans = dfs(s, i - 1) + 1;
        for (int j = 0; j < i; j++) {
            if (d.contains(s.substring(j, i))) {
                ans = Math.min(ans, dfs(s, j));
            }
        }
        g.put(i, ans);
        return ans;
    }

    public int minExtraChar(String s, String[] dictionary) {
        for (String v : dictionary) {
            d.add(v);
        }
        return dfs(s, s.length());
    }
}