class Solution {

    public int minimumDeletions(String word, int k) {
        int[] cnt = new int[26];
        for (char c : word.toCharArray()) {
            cnt[c - 'a']++;
        }
        int n = word.length();
        int ans = n;
        for (int x : cnt) {
            int c = 0;
            for (int v : cnt) {
                if (v >= x) {
                    c += Math.min(x + k, v);
                }
            }
            ans = Math.min(ans, n - c);
        }
        return ans;
    }
}