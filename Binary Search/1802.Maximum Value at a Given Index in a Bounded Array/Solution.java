class Solution {
    public int maxValue(int n, int index, int maxSum) {
        int left = 1, right = maxSum;
        while (left < right) {
            int mid = (left + right + 1) >>> 1;
            if (getCnt(mid, index + 1) + getCnt(mid, n - index) - mid <= maxSum) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public long getCnt(long x, int m) {
        return m >= x ? m - x + (x + 1) * x / 2 : (x + x - m + 1) * m / 2;
    }

}