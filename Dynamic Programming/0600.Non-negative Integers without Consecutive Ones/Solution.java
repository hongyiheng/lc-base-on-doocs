class Solution {

    String s;
    Map<String, Integer> f = new HashMap<>();

    public int dfs(int pos, int pre, boolean limit) {
        if (pos == s.length()) {
            return 1;
        }
        String key = pos + ":" + pre;
        if (!limit && f.containsKey(key)) {
            return f.get(key);
        }
        int up = limit ? s.charAt(pos) - '0' : 1;
        int ans = 0;
        for (int i = 0; i <= up; i++) {
            if (i == 1 && pre == 1) {
                continue;
            }
            ans += dfs(pos + 1, i, limit && i == up);
        }
        if (!limit) {
            f.put(key, ans);
        }
        return ans;
    }

    public int findIntegers(int n) {
        s = Integer.toBinaryString(n);
        return dfs(0, 0, true);
    }
}