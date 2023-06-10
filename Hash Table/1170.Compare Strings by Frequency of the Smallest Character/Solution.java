class Solution {
    public int f(String s) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        for (int v : cnt) {
            if (v > 0) {
                return v;
            }
        }
        return 0;
    }

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] vs = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            vs[i] = f(words[i]);
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int cur = f(queries[i]);
            for (int v : vs) {
                ans[i] += v > cur ? 1 : 0;
            }
        }
        return ans;
    }
}
