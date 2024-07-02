class Solution {
public int maximumPrimeDifference(int[] nums) {
        boolean[] primes = getPrimes(110);
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l < n && primes[nums[l]]) {
            l++;
        }
        while (r >= 0 && primes[nums[r]]) {
            r--;
        }
        return r - l;
    }

    private boolean[] getPrimes(int n) {
        boolean[] primes = new boolean[n];
        Arrays.fill(primes, false);
        for (int i = 2; i < n; i++) {
            if (!primes[i]) {
                for (int j = i * i; j < n; j += i) {
                    primes[j] = true;
                }
            }
        }
        primes[0] = primes[1] = true;
        return primes;
    }
}