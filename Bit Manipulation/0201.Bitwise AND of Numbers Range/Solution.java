class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int ans = 0;
        for (int i = 30; i > -1; i--) {
            if (left >= (1 << i) && right < (1L << (i + 1))) {
                ans |= 1 << i;
                left -= 1 << i;
                right -= 1 << i;
            }
        }
        return ans;
    }
}
