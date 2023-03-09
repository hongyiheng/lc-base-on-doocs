class Solution {
    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length();
        int l = 0, r = 0, ans = k, b = 0;
        while (r < n) {
            if (blocks.charAt(r) == 'B') {
                b++;
            }
            if (r - l + 1 > k) {
                if (blocks.charAt(l++) == 'B') {
                    b--;
                }
            }
            ans = Math.min(ans, k - b);
            r++;
        }
        return ans;
    }
}