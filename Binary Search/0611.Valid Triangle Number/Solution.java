class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int left = j + 1, right = n - 1;
                if (left >= n) {
                    continue;
                }
                while (left < right) {
                    int mid = (left + right + 1) >> 1;
                    if (nums[i] + nums[j] > nums[mid]) {
                        left = mid;
                    } else {
                        right = mid - 1;
                    }
                }
                if (nums[i] + nums[j] > nums[left]) {
                    ans += left - j;
                }
            }
        }
        return ans;
    }
}