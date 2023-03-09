class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] cnt = new int[n + 1];
        for (int[] sh : shifts) {
            cnt[sh[0]] += sh[2] == 1 ? 1 : -1;
            cnt[sh[1] + 1] -= sh[2] == 1 ? 1 : -1;
        }
        int v = 0;
        char[] cs = s.toCharArray();
        for (int i = 0; i < n; i++) {
            v += cnt[i];
            while (v < 0) {
                v += 26;
            }
            int cur = (cs[i] - 'a' + v) % 26;
            cs[i] = (char) (cur + 'a');
        }
        return new String(cs);
    }
}