class Solution {
    public int numPrimeArrangements(int n) {
        int mod = (int)1e9 + 7;
        int[] primes = new int[n + 1];
        int cnt = 1;
        for (int i = 2; i * i <= n; i++) {
            if (primes[i] == 0) {
                for (int j = i * i; j <= n; j += i) {
                    if (primes[j] == 0) {
                        primes[j] = 1;
                        cnt += 1;
                    }
                }
            }
        }
        int primeNum = n - cnt;
        long ans = 1;
        for (int i = primeNum; i > 0; i--) {
            ans = ans * i % mod;
        }
        for (int i = cnt; i > 0; i--) {
            ans = ans * i % mod;
        }
        return (int)ans % mod;
    }
}