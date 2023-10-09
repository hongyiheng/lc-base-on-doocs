class Solution {
    public int splitNum(int num) {
        int[] cnt = new int[10];
        while (num > 0) {
            cnt[num % 10]++;
            num /= 10;
        }
        int a = 0, b = 0, d = 0;
        for (int i = 1; i < cnt.length; i++) {
            while (cnt[i] > 0) {
                if (d == 0) {
                    a = a * 10 + i;
                } else {
                    b = b * 10 + i;
                }
                d ^= 1;
                cnt[i]--;
            }
        }
        return a + b;
    }
}