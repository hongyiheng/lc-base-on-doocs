class Solution {
    public int generateKey(int num1, int num2, int num3) {
        int ans = 0, i = 1;
        while (num1 > 0 || num2 > 0 || num3 > 0) {
            int v = num1 > 0 ? num1 % 10 : 0;
            v = Math.min(v, num2 > 0 ? num2 % 10 : 0);
            v = Math.min(v, num3 > 0 ? num3 % 10 : 0);
            num1 /= 10;
            num2 /= 10;
            num3 /= 10;
            ans = ans + v * i;
            i *= 10;
        }
        return ans;
    }
}