class Solution {
    public long minEnd(int n, int x) {
        n--;
        long j = 0, ans = x;
        for (int i = 0; i < 64; i++) {
            if ((ans & (1L << i)) == 0) {
                if ((n & (1L << j)) != 0) {
                    ans |= (1L << i);
                }
                j++;
            }
        }
        return ans;
    }
}