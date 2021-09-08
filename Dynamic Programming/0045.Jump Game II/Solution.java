class Solution {
    public int jump(int[] nums) {
        int len = nums.length;
        int ans = 0, start = 0, end = 1;
        while (end < len) {
            int temp = 0;
            for (int i = start; i < end; i++) {
                temp = Math.max(temp, i + nums[i]);
            }
            start = end;
            end = temp + 1;
            ans++;
        }
        return ans;
    }
}