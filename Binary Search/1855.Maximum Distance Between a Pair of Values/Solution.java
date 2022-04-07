class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int left = i, right = m - 1;
            if (right - left <= ans) {
                break;
            }
            while (left < right) {
                int mid = (left + right + 1) >> 1;
                if (nums2[mid] >= nums1[i]) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            if (nums2[left] >= nums1[i] && left >= i) {
                ans = Math.max(ans, left - i);
            }
        }
        return ans;
    }
}