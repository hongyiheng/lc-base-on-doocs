class Solution {
    public int maximumXOR(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            for (int v : nums) {
                if ((v >> i & 1) == 1) {
                    ans |= 1 << i;
                }
            }
        }
        return ans;
    }
}