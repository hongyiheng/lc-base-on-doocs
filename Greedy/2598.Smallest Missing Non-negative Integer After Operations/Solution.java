class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int[] cnt = new int[value];
        for (int v : nums) {
            cnt[((v % value) + value) % value]++;
        }
        int ans = 0;
        while (cnt[0] > 0) {
            for (int i = 0; i < value; i++) {
                if (cnt[i]-- > 0) {
                    ans++;
                } else {
                    return ans;
                }
            }
        }
        return ans;
    }
}