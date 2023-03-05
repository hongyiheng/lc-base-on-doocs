class Solution {
    public int[] leftRigthDifference(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n + 1];
        int s = 0;
        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + nums[i];
            s += nums[i];
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = Math.abs(pre[i] - (s - pre[i + 1]));
        }
        return ans;
    }
}