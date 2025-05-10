class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long s1 = 0, s2 = 0;
        int cnt1 = 0, cnt2 = 0;
        for (int v : nums1) {
            s1 += v;
            if (v == 0) {
                cnt1++;
            }
        }
        for (int v : nums2) {
            s2 += v;
            if (v == 0) {
                cnt2++;
            }
        }
        if ((cnt1 == 0 && s1 < s2 + cnt2) || (cnt2 == 0 && s1 + cnt1 > s2)) {
            return -1;
        }
        return Math.max(s1 + cnt1, s2 + cnt2);
    }
}