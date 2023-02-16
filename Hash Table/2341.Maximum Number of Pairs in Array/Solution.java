class Solution {
    public int[] numberOfPairs(int[] nums) {
        int[] cnt = new int[110];
        for (int v : nums) {
            cnt[v]++;
        }
        int[] ans = new int[2];
        for (int i = 0; i < 110; i++) {
            ans[0] += cnt[i] / 2;
            ans[1] += cnt[i] % 2;
        }
        return ans;
    }
}
