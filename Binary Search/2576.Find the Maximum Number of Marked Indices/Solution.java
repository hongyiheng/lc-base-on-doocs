class Solution {

    int n;

    public int maxNumOfMarkedIndices(int[] nums) {
        n = nums.length;
        Arrays.sort(nums);
        int l = 0, r = n / 2;
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (check(nums, mid)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l * 2;
    }

    public boolean check(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            if (2 * nums[i] > nums[n - k + i]) {
                return false;
            }
        }
        return true;
    }


}