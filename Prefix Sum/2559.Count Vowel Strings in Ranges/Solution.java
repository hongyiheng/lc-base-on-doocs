class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        Set<Character> s = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int n = words.length, m = queries.length;
        int[] pre = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int k = words[i].length();
            pre[i + 1] = pre[i] + (s.contains(words[i].charAt(0)) && s.contains(words[i].charAt(k - 1)) ? 1 : 0);
        }
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            ans[i] = pre[queries[i][1] + 1] - pre[queries[i][0]];
        }
        return ans;
    }
}
