class Solution {
    public long minOperations(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        if (k == 0) {
            for (int i = 0; i < n; i++) {
                if (nums1[i] != nums2[i]) {
                    return -1;
                }
            }
            return 0;
        }
        long ans = 0, diff = 0;
        for (int i = 0; i < n; i++) {
            if (Math.abs(nums1[i] - nums2[i]) % k != 0) {
                return -1;
            }
            if (nums1[i] - nums2[i] > 0) {
                ans += (nums1[i] - nums2[i]) / k;
            }
            diff += nums1[i] - nums2[i];
        }
        return diff == 0 ? ans : -1;
    }
}
