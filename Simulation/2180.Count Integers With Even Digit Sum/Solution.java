class Solution {
    public int countEven(int num) {
        int ans = 0;
        for (int i = 2; i <= num; i++) {
            int v = i, cnt = 0;
            while (v > 0) {
                cnt += v % 10;
                v /= 10;
            }
            if (cnt % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }
}