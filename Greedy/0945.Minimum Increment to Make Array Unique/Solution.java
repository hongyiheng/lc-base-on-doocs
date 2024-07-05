class Solution {
    public int minIncrementForUnique(int[] nums) {
        int[] cnt = new int[110000];
        for (int v : nums) {
            cnt[v]++;
        }
        int ans = 0, s = 0;
        for (int i = 0; i < 110000; i++) {
            if (cnt[i] >= 1) {
                s += cnt[i] - 1;
            } else if (s > 0) {
                s--;
            }
            ans += s;
        }
        return ans;
    }
}