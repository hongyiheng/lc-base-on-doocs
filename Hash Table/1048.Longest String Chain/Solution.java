class Solution {

    Map<Integer, List<String>> ws;

    Map<String, Integer> f;

    public int dfs(String cur) {
        if (f.containsKey(cur)) {
            return f.get(cur);
        }
        int ans = 1;
        for (String w : ws.getOrDefault(cur.length() + 1, new ArrayList<>())) {
            for (int i = 0; i < w.length(); i++) {
                if ((w.substring(0, i) + w.substring(i + 1)).equals(cur)) {
                    ans = Math.max(ans, dfs(w) + 1);
                }
            }
        }
        f.put(cur, ans);
        return ans;
    }

    public int longestStrChain(String[] words) {
        ws = new HashMap<>();
        f = new HashMap<>();
        for (String w : words) {
            ws.computeIfAbsent(w.length(), x -> new ArrayList<>()).add(w);
        }
        int ans = 0;
        for (String w : words) {
            ans = Math.max(ans, dfs(w));
        }
        return ans;
    }
}
