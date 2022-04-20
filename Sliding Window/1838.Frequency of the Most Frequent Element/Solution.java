class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, right = 1, ans = 1, n = nums.length;
        long need = 0;
        while (right < n) {
            need += (right - left) * (nums[right] - nums[right - 1]);
            while (need > k) {
                need -= nums[right] - nums[left++];
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }
}