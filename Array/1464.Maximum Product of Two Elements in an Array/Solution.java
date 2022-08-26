class Solution {
    public int maxProduct(int[] nums) {
        int f = 0, s = 0;
        for (int v : nums) {
            if (v >= f) {
                s = f;
                f = v;
            } else if (v > s) {
                s = v;
            }
        }
        return (f - 1) * (s - 1);
    }
}