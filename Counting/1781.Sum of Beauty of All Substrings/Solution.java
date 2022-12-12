class Solution {
    public int beautySum(String s) {
        int ans = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            int[] cnt = new int[26];
            for (int j = i; j < n; j++) {
                cnt[s.charAt(j) - 'a']++;
                int mx = 0, mi = 500;
                for (int v : cnt) {
                    if (v == 0) {
                        continue;
                    }
                    mx = Math.max(mx, v);
                    mi = Math.min(mi, v);
                }
                ans += mx - mi;
            }
        }
        return ans;
    }
}
