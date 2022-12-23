class Solution {
    public int smallestValue(int n) {
        while (true) {
            int x = n, ans = 0, i = 2;
            while (i * i <= x) {
                while (x % i == 0) {
                    ans += i;
                    x /= i;
                }
                i++;
            }
            if (x >= 2) {
                ans += x;
            }
            if (ans == n) {
                return ans;
            }
            n = ans;
        }
    }
}