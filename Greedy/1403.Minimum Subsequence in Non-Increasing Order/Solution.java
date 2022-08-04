class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        int n = nums.length, s = 0, cur = 0;
        for (int v : nums) {
            s += v;
        }
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            if (cur > s) {
                break;
            }
            s -= nums[i];
            cur += nums[i];
            ans.add(nums[i]);
        }
        return ans;
    }
}