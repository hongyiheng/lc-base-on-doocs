class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }
        for (int i = 16; i > -1; i--) {
            if ((n >> i & 1) != 0) {
                return 1 << (i + 1);
            }
        }
        return -1;
    }
}