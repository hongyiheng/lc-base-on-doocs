class Solution {
    public int differenceOfSum(int[] nums) {
        int a = 0, b = 0;
        for (int v : nums) {
            a += v;
            while (v > 0) {
                b += v % 10;
                v /= 10;
            }
        }
        return Math.abs(a - b);
    }
}