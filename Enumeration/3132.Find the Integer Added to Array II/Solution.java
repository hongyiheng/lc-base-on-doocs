class Solution {

    public boolean check(int x, int[] nums1, int[] nums2) {
        int i = 0, d = 0;
        while (i < nums2.length && d <= 2) {
            if (nums1[i + d] + x != nums2[i]) {
                d++;
            } else {
                i++;
            }
        }
        return i == nums2.length;
    }

    public int minimumAddedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] xs = new int[3];
        for (int i = 0; i < 3; i++) {
            xs[i] = nums2[0] - nums1[i];
        }
        Arrays.sort(xs);
        for (int x : xs) {
            if (check(x, nums1, nums2)) {
                return x;
            }
        }
        return 0;
    }
}