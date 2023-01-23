class Solution {
    public double calculateTax(int[][] brackets, int income) {
        double last = 0, ans = 0;
        for (int[] b : brackets) {
            if (income <= last) {
                break;
            }
            int u = b[0], p = b[1];
            ans += (Math.min(u, income) - last) * p / 100;
            last = u;
        }
        return ans;
    }
}