class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        int[] cnt = new int[46];
        for (int i = lowLimit; i < highLimit + 1; i++) {
            int num = i, index = 0;
            while (num > 0) {
                index += num % 10;
                num /= 10;
            }
            cnt[index]++;
        }
        int ans = 0;
        for (int v : cnt) {
            ans = Math.max(ans, v);
        }
        return ans;
    }
}