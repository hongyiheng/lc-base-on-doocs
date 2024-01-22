class Solution {

    int n;

    public int f(int[] nums1, int[] nums2) {
        int mxA = nums1[n - 1], mxB = nums2[n - 1];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int a = nums1[i], b = nums2[i];
            if (a <= mxA && b <= mxB) {
                continue;
            }
            if (b <= mxA && a <= mxB) {
                ans++;
                continue;
            }
            return -1;
        }
        return ans;
    }

    public int minOperations(int[] nums1, int[] nums2) {
        n = nums1.length;
        int ans1 = f(nums1, nums2);
        int tmp = nums1[n - 1];
        nums1[n - 1] = nums2[n - 1];
        nums2[n - 1] = tmp;
        int ans2 = f(nums1, nums2);
        if (ans2 == -1) {
            return ans1;
        }
        if (ans1 == -1) {
            return ans2 + 1;
        }
        return Math.min(ans1, ans2 + 1);
    }
}