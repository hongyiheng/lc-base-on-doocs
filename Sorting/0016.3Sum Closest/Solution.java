class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE, n = nums.length;
        for (int i = 0; i < n; i++) {
            int left = i + 1, right = n - 1;
            while (left < right) {
                int cur = nums[i] + nums[left] + nums[right];
                if (Math.abs(cur - target) <= Math.abs(ans - target)) {
                    ans = cur;
                }
                if (cur < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return ans;
    }
}
