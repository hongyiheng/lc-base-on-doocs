class Solution {
    public int minDeletions(String s) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        Set<Integer> vis = new HashSet<>();
        int ans = 0;
        for (int v : cnt) {
            if (v == 0) {
                continue;
            }
            while (vis.contains(v)) {
                v--;
                ans++;
            }
            if (v != 0) {
                vis.add(v);
            }
        }
        return ans;
    }
}