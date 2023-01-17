class Solution {
    public int findNthDigit(int n) {
        if (n < 10) {
            return n;
        }
        n -= 9;
        int i = 1;
        while (true) {
            if (n <= 9 * (i + 1) * Math.pow(10, i)) {
                break;
            }
            n -= 9 * (i + 1) * Math.pow(10, i);
            i++;
        }
        n--;
        int num = (int) Math.pow(10, i) + n / (i + 1);
        return String.valueOf(num).charAt(n % (i + 1)) - '0';
    }
}
