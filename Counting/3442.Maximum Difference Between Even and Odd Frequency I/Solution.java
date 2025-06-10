class Solution {
    public int maxDifference(String s) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        int mi = 110, mx = 1;
        for (int v : cnt) {
            if (v == 0) {
                continue;
            }
            if (v % 2 == 1) {
                mx = Math.max(mx, v);
            } else {
                mi = Math.min(mi, v);
            }
        }
        return mx - mi;
    }
}