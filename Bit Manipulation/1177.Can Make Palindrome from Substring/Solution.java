class Solution {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int n = s.length();
        int[] cnt = new int[n + 1];
        for (int i = 0; i < n; i++) {
            cnt[i + 1] = cnt[i] ^ (1 << (s.charAt(i) - 'a'));
        }
        List<Boolean> ans = new ArrayList<>();
        for (int[] q : queries) {
            int l = q[0], r = q[1], k = q[2];
            int mask = cnt[r + 1] ^ cnt[l];
            int w = 0;
            for (int i = 0; i < 27; i++) {
                if ((mask & (1 << i)) != 0) {
                    w++;
                }
            }
            ans.add(w / 2 <= k);
        }
        return ans;
    }
}
