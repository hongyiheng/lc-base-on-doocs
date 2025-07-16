class Solution {
    public int maximumLength(int[] nums) {
        int f00 = 0, f01 = 0, f10 = 0, f11 = 0;
        for (int v : nums) {
            if (v % 2 == 1) {
                f11++;
                f10 = f01 + 1;
            } else {
                f00++;
                f01 = f10 + 1;
            }
        }
        return Math.max(Math.max(f00, f11), Math.max(f01, f10));
    }
}