class Solution {
    public int duplicateNumbersXOR(int[] nums) {
        boolean[] cnt = new boolean[51];
        int ans = 0;
        for (int v : nums) {
            if (cnt[v]) {
                ans ^= v;
            }
            cnt[v] = true;
        }
        return ans;
    }
}