class Solution {
    public long distributeCandies(int n, int limit) {
        int start = n > 2 * limit ? n - 2 * limit : 0;
        int l = 0, r = Math.min(n - start, limit);
        while (l < r) {
            int mid = (l + r) >> 1;
            if (n - start - mid > limit) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        long ans = 0;
        for (int i = start; i <= Math.min(n, limit); i++) {
            while (l > 0 && n - i - l + 1 <= limit) {
                l--;
            }
            ans += Math.min(n - i, limit) - l + 1;
        }
        return ans;
    }
}