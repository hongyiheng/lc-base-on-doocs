class Solution {

    Map<Integer, List<Integer>> g;
    Map<Integer, Integer> cnt;
    String s;

    public long dfs(int u, int mask) {
        long ans = 0;
        for (int v : g.getOrDefault(u, new ArrayList<>())) {
            int nm = mask ^ (1 << (s.charAt(v) - 'a'));
            ans += cnt.getOrDefault(nm, 0);
            for (int i = 0; i < 26; i++) {
                ans += cnt.getOrDefault(nm ^ (1 << i), 0);
            }
            cnt.put(nm, cnt.getOrDefault(nm, 0) + 1);
            ans += dfs(v, nm);
        }
        return ans;
    }

    public long countPalindromePaths(List<Integer> parent, String s) {
        g = new HashMap<>();
        cnt = new HashMap<>();
        this.s = s;
        for (int i = 0; i < parent.size(); i++) {
            g.computeIfAbsent(parent.get(i), k -> new ArrayList<>()).add(i);
        }
        cnt.put(0, 1);
        return dfs(0, 0);
    }
}