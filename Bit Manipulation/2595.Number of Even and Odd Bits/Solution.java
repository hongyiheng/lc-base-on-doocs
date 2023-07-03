class Solution {
    public int[] evenOddBit(int n) {
        int[] ans = new int[2];
        for (int i = 0; i < 10; i++) {
            ans[i & 1] += n >> i & 1;
        }
        return ans;
    }
}