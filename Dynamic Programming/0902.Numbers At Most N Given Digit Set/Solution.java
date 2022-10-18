class Solution {
    int[] ds;
    String s;
    Map<Integer, Integer> mp;

    public int atMostNGivenDigitSet(String[] digits, int n) {
        ds = new int[digits.length];
        for (int i = 0; i < digits.length; i++) {
            ds[i] = Integer.valueOf(digits[i]);
        }
        s = String.valueOf(n);
        mp = new HashMap<>();
        return dfs(0, true, false);
    }

    public int dfs(int i, boolean limit, boolean num) {
        if (i == s.length()) {
            return num ? 1 : 0;
        }
        if (mp.containsKey(i) && !limit && num) {
            return mp.get(i);
        }
        int ans = 0;
        if (!num) {
            ans = dfs(i + 1, false, false);
        }
        int up = limit ? s.charAt(i) - '0' : 9;
        for (int v : ds) {
            if (v > up) {
                break;
            }
            ans += dfs(i + 1, limit && v == up, true);
        }
        if (!limit && num) {
            mp.put(i, ans);
        }
        return ans;
    }
}
