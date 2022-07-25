class Solution {
    int ans = 0;

    public int reversePairs(int[] nums) {
        int n = nums.length;
        int[] tmp = new int[n];
        sort(nums, tmp, 0, n - 1);
        return ans;
    }

    public void sort(int[] nums, int[] tmp, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) >> 1;
        sort(nums, tmp, left, mid);
        sort(nums, tmp, mid + 1, right);
        merge(nums, tmp, left, right, mid);
    }

    public void merge(int[] nums, int[] tmp, int left, int right, int mid) {
        int l = left, r = mid + 1;
        while (l <= mid && r <= right) {
            if (nums[l] <= 2L * nums[r]) {
                l++;
            } else {
                ans += mid - l + 1;
                r++;
            }
        }
        l = left;
        r = mid + 1;
        int t = left;
        while (l <= mid || r <= right) {
            if (r > right || (l <= mid && nums[l] <= nums[r])) {
                tmp[t++] = nums[l++];
            } else {
                tmp[t++] = nums[r++];
            }
        }
        for (int i = left; i <= right; i++) {
            nums[i] = tmp[i];
        }
    }
}