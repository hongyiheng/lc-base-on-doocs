class Solution {
    public char kthCharacter(long k, int[] operations) {
        int m = 0;
        while (1L << m < k) {
            m++;
        }
        long pos = k, cnt = 0;
        while(m > 0) {
            long half = 1L << (m - 1);
            if (pos > half) {
                cnt += operations[m - 1];
                pos -= half;
            }
            m--;
        }
        return (char)(cnt % 26 + 'a');
    }
}