class Solution {
    public long minimumMoney(int[][] transactions) {
        long s = 0;
        for (int[] t : transactions) {
            int a = t[0], b = t[1];
            if (a > b) {
                s += a - b;
            }
        }
        long ans = 0;
        for (int[] t : transactions) {
            int a = t[0], b = t[1];
            if (a > b) {
                ans = Math.max(ans, s + b);
            } else {
                ans = Math.max(ans, s + a);
            }
        }
        return ans;
    }
}