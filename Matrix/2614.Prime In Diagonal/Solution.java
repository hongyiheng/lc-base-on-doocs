class Solution {

    public boolean isPrime(int v) {
        for (int i = 2; i < (int)Math.sqrt(v) + 1; i++) {
            if (v % i == 0) {
                return false;
            }
        }
        return v >= 2;
    }

    public int diagonalPrime(int[][] nums) {
        int ans = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            int[] row = nums[i];
            for (int v : new int[]{row[i], row[n - i - 1]}) {
                if (v > ans && isPrime(v)) {
                    ans = v;
                }
            }
        }
        return ans;
    }
}