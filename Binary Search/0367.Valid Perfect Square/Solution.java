class Solution {
    public boolean isPerfectSquare(int num) {
        int left = 1, right = num / 2;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if ((long)mid * mid < num) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left * left == num;
    }
}