class Solution {
    public boolean hasTrailingZeros(int[] nums) {
        int zero = 0;
        for (int v : nums) {
            if ((v & 1) == 0) {
                zero++;
            }
        }
        return zero >= 2;
    }
}