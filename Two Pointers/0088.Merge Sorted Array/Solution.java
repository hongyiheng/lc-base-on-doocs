class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx = (m + n) - 1;
        m--;
        n--;
        while (m >= 0 && n >= 0) {
            if (nums1[m] > nums2[n]) {
                nums1[idx--] = nums1[m--];
            } else {
                nums1[idx--] = nums2[n--];
            }
        }
        for (int i = 0; i <= n; i++) {
            nums1[i] = nums2[i];
        }
    }
}