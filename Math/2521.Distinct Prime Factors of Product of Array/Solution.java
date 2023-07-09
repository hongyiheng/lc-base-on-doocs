class Solution {
    public int distinctPrimeFactors(int[] nums) {
        int M = 1010;
        boolean[] primes = new boolean[M];
        for (int i = 2; i < M; i++) {
            if (!primes[i]) {
                for (int j = i * i; j < M; j += i) {
                    primes[j] = true;
                }
            }
        }
        Set<Integer> ans = new HashSet<>();
        for (int v : nums) {
            for (int i = 2; i < M; i++) {
                if (i > v) {
                    break;
                }
                if (!primes[i] && v % i == 0) {
                    ans.add(i);
                    while (v % i == 0) {
                        v /= i;
                    }
                }
            }
            if (v > 1) {
                ans.add(v);
            }
        }
        return ans.size();
    }
}