class Solution {
    public int sumOfUnique(int[] nums) {
        int[] cnt = new int[110];
        for (int num : nums) {
            cnt[num]++;
        }
        int ans = 0;
        for (int i = 0; i < 110; i++) {
            if (cnt[i] == 1) {
                ans += i;
            }
        }
        return ans;
    }
}