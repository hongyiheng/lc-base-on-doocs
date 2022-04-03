class Solution {
    public int arrangeCoins(int n) {
        int left = 0, right = n;
        while (left < right) {
            int mid = (left + right + 1) >>> 1;
            if ((long)(1 + mid) * mid / 2 > n) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }
}