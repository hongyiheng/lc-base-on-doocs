class Solution {
    int[] ribbons;
    int k;

    public int maxLength(int[] ribbons, int k) {
        this.ribbons = ribbons;
        this.k = k;
        int left = 0, right = 100000;
        while (left < right) {
            int mid = (left + right + 1) >> 1;
            if (check(mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public boolean check(int m) {
        int cnt = 0;
        for (int v : ribbons) {
            cnt += v / m;
            if (cnt >= k) {
                return true;
            }
        }
        return false;
    }
}