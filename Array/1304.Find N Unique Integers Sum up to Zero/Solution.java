class Solution {
    public int[] sumZero(int n) {
        int x = 500;
        int[] ans = new int[n];
        for (int i = n; i > 0; i -= 2) {
            if (i == 1) {
                ans[i - 1] = 0;
            } else {
                ans[i - 1] = x;
                ans[i - 2] = -x;
            }
            x--;
        }
        return ans;
    }
}