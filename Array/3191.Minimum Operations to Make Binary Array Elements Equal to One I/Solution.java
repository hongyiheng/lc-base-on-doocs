class Solution {
    public int minOperations(int[] nums) {
        int ans = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                continue;
            }
            if (i + 2 >= n) {
                return -1;
            }
            for (int j = i + 1; j < i + 3; j++) {
                nums[j] ^= 1;
            }
            ans++;
        }
        return ans;
    }
}