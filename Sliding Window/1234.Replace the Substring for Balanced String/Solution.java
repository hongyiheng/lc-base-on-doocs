class Solution {

    Map<Character, Integer> mp = new HashMap<>();
    int t = 0;

    public int balancedString(String s) {
        mp.put('Q', 0);
        mp.put('W', 1);
        mp.put('E', 2);
        mp.put('R', 3);

        int n = s.length();
        t = n / 4;
        int[] cnt = new int[4];
        for (int i = 0; i < n; i++) {
            cnt[mp.get(s.charAt(i))]++;
        }
        int[] cur = new int[4];
        if (check(cnt, cur)) {
            return 0;
        }
        int ans = n;
        int l = 0, r = 0;
        while (r < n) {
            cur[mp.get(s.charAt(r))]++;
            while (l <= r && check(cnt, cur)) {
                ans = Math.min(ans, r - l + 1);
                cur[mp.get(s.charAt(l++))]--;
            }
            r++;
        }
        return ans;
    }

    public boolean check(int[] cnt, int[] cur) {
        boolean ans = true;
        for (int i = 0; i < 4; i++) {
            ans &= (cnt[i] < t || cur[i] >= cnt[i] - t);
        }
        return ans;
    }
}