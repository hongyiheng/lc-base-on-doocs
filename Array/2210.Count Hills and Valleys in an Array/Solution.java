class Solution {
    public int countHillValley(int[] nums) {
        int n = nums.length;
        int i = 0, ans = 0;
        while (i < n) {
            int left = i - 1, right = i + 1;
            while (left > 0 && nums[left] == nums[i]) {
                left--;
            }
            while (right < n && nums[right] == nums[i]) {
                right++;
            }
            if (left < 0 || right >= n) {
                i++;
                continue;
            }
            if (nums[left] < nums[i] && nums[right] < nums[i]) {
                ans ++;
            }
            if (nums[left] > nums[i] && nums[right] > nums[i]) {
                ans ++;
            }
            i = right;
        }
        return ans;
    }
}