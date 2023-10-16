class Solution {
    public int findDuplicate(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int v = nums[i];
            if (i == v) {
                i++;
                continue;
            }
            if (nums[i] == nums[v]) {
                return v;
            }
            int t = nums[i];
            nums[i] = nums[v];
            nums[v] = t;
        }
        return -1;
    }
}
