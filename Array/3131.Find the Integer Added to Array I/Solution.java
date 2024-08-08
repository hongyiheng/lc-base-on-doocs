class Solution {
    public int addedInteger(int[] nums1, int[] nums2) {
        int m1 = nums1[0], m2 = nums2[0];
        for (int v : nums1) {
            m1 = Math.min(v, m1);
        }
        for (int v : nums2) {
            m2 = Math.min(v, m2);
        }
        return m2 - m1;
    }
}