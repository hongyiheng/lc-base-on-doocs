class Solution {
    public int nthMagicalNumber(int n, int a, int b) {
        int mod = (int)1e9 + 7;
        if (b > a) {
            return nthMagicalNumber(n, b, a);
        }
        long c = 1L * a * b / gcd(a, b);
        long left = 0, right = 1L * a * n;
        while (left < right) {
            long mid = (left + right) >>> 1;
            if (mid / a + mid / b - mid / c < n) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return (int)(left % mod);
    }

    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
