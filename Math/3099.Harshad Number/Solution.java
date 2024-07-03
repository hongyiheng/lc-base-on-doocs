class Solution {
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int s = 0, v = x;
        while (v > 0) {
            s += v % 10;
            v /= 10;
        }
        return x % s == 0 ? s : -1;
    }
}