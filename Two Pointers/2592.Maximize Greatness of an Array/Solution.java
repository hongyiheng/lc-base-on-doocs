class Solution {
    public int maximizeGreatness(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int l = 0, r = 0, ans = 0;
        while (r < n) {
            if (nums[r] > nums[l]) {
                ans++;
                l++;
            }
            r++;
        }
        return ans;
    }
}