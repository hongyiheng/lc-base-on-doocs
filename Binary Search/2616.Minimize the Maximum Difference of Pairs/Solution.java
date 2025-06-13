class Solution {

    public boolean check(int[] nums, int x, int p) {
        int cnt = 0, i = 0;
        while (i < nums.length - 1) {
            if (nums[i + 1] - nums[i] <= x) {
                cnt++;
                i++;
            }
            i++;
        }
        return cnt >= p;
    }

    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int l = 0, r = nums[nums.length - 1] - nums[0];
        while (l < r) {
            int mid = (l + r) >> 1;
            if (check(nums, mid, p)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }
}