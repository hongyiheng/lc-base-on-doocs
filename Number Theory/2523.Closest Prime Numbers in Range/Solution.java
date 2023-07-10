class Solution {
    public int[] closestPrimes(int left, int right) {
        boolean[] primes = new boolean[right + 1];
        for (long i = 2; i <= right; i++) {
            if (!primes[(int)i]) {
                for (long j = i * i; j <= right; j += i) {
                    primes[(int)j] = true;
                }
            }
        }
        int[] ans = null;
        int last = -1;
        for (int i = Math.max(left, 2); i <= right; i++) {
            if (!primes[i]) {
                if (last != -1 && (ans == null || ans[1] - ans[0] > i - last)) {
                    ans = new int[]{last, i};
                }
                last = i;
            }
        }
        return ans == null ? new int[]{-1, -1,} : ans;
    }
}