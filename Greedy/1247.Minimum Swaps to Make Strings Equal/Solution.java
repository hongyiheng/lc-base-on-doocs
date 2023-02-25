class Solution {
    public int minimumSwap(String s1, String s2) {
        int n = s1.length();
        int[] cnt = new int[]{0, 0};
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                cnt[s1.charAt(i) % 2]++;
            }
        }
        int d = cnt[0] + cnt[1];
        return d % 2 != 0 ? -1 : d / 2 + cnt[0] % 2;
    }
}