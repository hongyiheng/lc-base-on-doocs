class Solution {
    public int getMax(int[] nums1, int[] nums2) {
        int s = 0, diff = 0, mx = 0;
        for (int i = 0; i < nums1.length; i++) {
            s += nums1[i];
            diff = Math.max(diff + nums2[i] - nums1[i], 0);
            mx = Math.max(mx, diff);
        }
        return s + mx;
    }

    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        return Math.max(getMax(nums1, nums2), getMax(nums2, nums1));
    }
}