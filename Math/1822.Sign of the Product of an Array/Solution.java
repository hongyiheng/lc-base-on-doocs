class Solution {
    public int arraySign(int[] nums) {
        boolean pos = true;
        for (int v : nums) {
            if (v < 0) {
                pos = !pos;
            }
            if (v == 0) {
                return 0;
            }
        }
        return pos ? 1 : -1;
    }
}
