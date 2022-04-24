class Solution {
    public int binaryGap(int n) {
        int ans = 0, last = -1;
        for (int i = 0; i < 32; i++) {
            if (((1 << i) & n) != 0) {
                if (last != -1) {
                    ans = Math.max(ans, i - last);
                }
                last = i;
            }
        }
        return ans;
    }
}