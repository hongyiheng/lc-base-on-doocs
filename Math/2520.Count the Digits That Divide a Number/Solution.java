class Solution {
    public int countDigits(int num) {
        int ans = 0, v = num;
        while (v > 0) {
            if (num % (v % 10) == 0) {
                ans++;
            }
            v /= 10;
        }
        return ans;
    }
}