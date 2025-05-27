class Solution {
    public int differenceOfSums(int n, int m) {
        int ans = 0;
        for (int i = 0; i < n + 1; i++) {
            if (i % m != 0) {
                ans += i;
            } else {
                ans -= i;
            }
        }
        return ans;
    }
}