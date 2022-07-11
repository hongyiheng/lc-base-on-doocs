class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[] nums = new int[m + n];
        int l = 0, r = 0;
        while (l < m || r < n) {
            if (l < m && r < n) {
                if (nums1[l] < nums2[r]) {
                    nums[l + r] = nums1[l];
                    l++;
                } else {
                    nums[l + r] = nums2[r];
                    r++;
                }
            } else if (l < m) {
                nums[l + r] = nums1[l];
                l++;
            } else {
                nums[l + r] = nums2[r];
                r++;
            }
        }
        double ans = 0;
        if ((m + n) % 2 == 0) {
            ans = (nums[(m + n) / 2] + nums[(m + n) / 2 - 1]) / 2.0;
        } else {
            ans = nums[(m + n) / 2];
        }
        return ans;
    }
}