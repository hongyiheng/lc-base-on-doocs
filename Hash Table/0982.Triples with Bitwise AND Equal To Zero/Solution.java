class Solution {
    public int countTriplets(int[] nums) {
        int[] cnt = new int[1 << 16];
        for (int i : nums) {
            for (int j : nums) {
                cnt[i & j]++;
            }
        }
        int ans = 0;
        for (int k : nums) {
            for (int i = 0; i < (1 << 16); i++) {
                if ((k & i) == 0) {
                    ans += cnt[i];
                }
            }
        }
        return ans;
    }
}