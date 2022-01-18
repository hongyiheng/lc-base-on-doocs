class Solution {
    public boolean judgeSquareSum(int c) {
        int i = 0, j = (int) Math.sqrt(c);
        while (i <= j) {
            long cur = (long) i * i + (long) j * j;
            if (cur == c) {
                return true;
            }
            if (cur > c) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}