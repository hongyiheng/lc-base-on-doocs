class Solution {
    public void sortColors(int[] nums) {
        int[] cnt = new int[3];
        for (int v : nums) {
            cnt[v]++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (cnt[0] != 0) {
                nums[i] = 0;
                cnt[0]--;
            } else if (cnt[1] != 0) {
                nums[i] = 1;
                cnt[1]--;
            } else {
                nums[i] = 2;
            }
        }
    }
}