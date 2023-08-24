class Solution {

    Map<String, Boolean> f;
    Set<Integer> s;
    int t;

    public boolean canCross(int[] stones) {
        f = new HashMap<>();
        s = new HashSet<>(Arrays.stream(stones).boxed().collect(Collectors.toList()));
        t = stones[stones.length - 1];
        return dfs(0, 0);
    }

    public boolean dfs(int pos, int k) {
        String key = pos + ":" + k;
        if (f.containsKey(key)) {
            return f.get(key);
        }
        if (pos == t) {
            return true;
        }
        boolean ans = false;
        for (int i = -1; i <= 1; i++) {
            int nx = pos + k + i;
            if (nx <= pos || !s.contains(nx)) {
                continue;
            }
            ans = ans || dfs(nx, k + i);
        }
        f.put(key, ans);
        return ans;
    }
}