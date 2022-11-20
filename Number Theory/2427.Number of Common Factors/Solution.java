class Solution {
    public int commonFactors(int a, int b) {
        int ans = 0, g = gcd(a, b), i = 1;
        while (i * i <= g) {
            if (g % i == 0) {
                ans++;
                if (i * i != g) {
                    ans++;
                }
            }
            i++;
        }
        return ans;
    }

    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
