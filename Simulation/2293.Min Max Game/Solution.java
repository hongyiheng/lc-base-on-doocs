class Solution {
    public int minMaxGame(int[] nums) {
        while (nums.length > 1) {
            boolean flag = true;
            int[] tmp = new int[nums.length / 2];
            for (int i = 0; i < tmp.length; i++) {
                tmp[i] = flag ? Math.min(nums[i * 2], nums[i * 2 + 1]) : Math.max(nums[i * 2], nums[i * 2 + 1]);
                flag = !flag;
            }
            nums = tmp;
        }
        return nums[0];
    }
}