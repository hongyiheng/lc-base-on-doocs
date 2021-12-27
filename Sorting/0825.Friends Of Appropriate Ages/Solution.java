class Solution {
    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int ans = 0, n = ages.length;

        for (int k = 0, l = 0, r = 0; k < n; k++) {
            r = Math.max(r, k);
            while (l < k && !check(ages[l], ages[k])) {
                l++;
            }
            while (r < n && check(ages[r], ages[k])) {
                r++;
            }
            if (r > l) {
                ans += r - l - 1;
            }
        }
        return ans;
    }

    public boolean check(int x, int y) {
        if (y <= 0.5 * x + 7) {
            return false;
        }
        if (y > x) {
            return false;
        }
        if (y > 100 && x < 100) {
            return false;
        }
        return true;
    }
}