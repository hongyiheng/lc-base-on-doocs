class Solution {
    public int countPoints(String rings) {
        int[] cnt = new int[10];
        for (int i = 0; i < rings.length(); i += 2) {
            cnt[rings.charAt(i + 1) - '0'] |= 1 << (rings.charAt(i) - 'A');
        }
        int ans = 0;
        int t = 1 << ('R' - 'A') | 1 << ('G' - 'A') | 1 << ('B' - 'A');
        for (int v : cnt) {
            if (v == t) {
                ans++;
            }
        }
        return ans;
    }
}