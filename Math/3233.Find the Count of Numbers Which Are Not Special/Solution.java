class Solution {

    private boolean[] getPrimes() {
        int n = 34000;
        boolean[] primes = new boolean[n];
        for (int i = 2; i < n; i++) {
            if (!primes[i]) {
                for (int j = i * i; j < n; j += i) {
                    primes[j] = true;
                }
            }
        }
        primes[1] = true;
        return primes;
    }

    public int nonSpecialCount(int l, int r) {
        int ans = r - l + 1;
        boolean[] primes = getPrimes();
        for (int i = (int)Math.sqrt(l); i < (int)Math.sqrt(r) + 1; i++) {
            if (l <= i * i && i * i <= r && !primes[i]) {
                ans--;
            }
        }
        return ans;
    }
}