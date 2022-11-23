class Solution {
    public int minimizeXor(int num1, int num2) {
        int k = lowbit(num2);
        int[] cnt = new int[32];
        for (int i = 31; i >= 0; i--) {
            if (((1 << i) & num1) != 0 && k > 0) {
                cnt[i] = 1;
                k--;
            }
        }
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if (k > 0 && cnt[i] == 0) {
                cnt[i] = 1;
                k--;
            }
            if (cnt[i] == 1) {
                ans += (1 << i);
            }
        }
        return ans;
    }

    public int lowbit(int x) {
        int ans = 0;
        while (x > 0) {
            x -= x & -x;
            ans++;
        }
        return ans;
    }
}
