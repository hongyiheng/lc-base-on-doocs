class Solution {
    public int minSwap(int[] nums1, int[] nums2) {
        int n = nums1.length, noSwap = 0, swap = 1;
        for (int i = 1; i < n; i++) {
            int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE;
            if (nums1[i - 1] < nums1[i] && nums2[i - 1] < nums2[i]) {
                a = noSwap;
                b = swap + 1;
            }
            if (nums1[i - 1] < nums2[i] && nums2[i - 1] < nums1[i]) {
                a = Math.min(a, swap);
                b = Math.min(b, noSwap + 1);
            }
            noSwap = a;
            swap = b;
        }
        return Math.min(noSwap, swap);
    }
}
