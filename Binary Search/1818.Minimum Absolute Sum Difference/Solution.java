class Solution {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        double mod = 1e9 + 7;
        int[] nums = nums1.clone();
        Arrays.sort(nums);
        int n = nums1.length;
        long s = 0, maxDiff = 0;
        for (int i = 0; i < n; i++) {
            int cur = Math.abs(nums1[i] - nums2[i]);
            s += cur;
            if (cur > maxDiff) {
                int left = 0, right = n - 1;
                while (left < right) {
                    int mid = (left + right) >> 1;
                    if (nums[mid] < nums2[i]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                int diff = Math.abs(nums[left] - nums2[i]);
                if (left > 0) {
                    diff = Math.min(diff, Math.abs(nums[left - 1] - nums2[i]));
                }
                maxDiff = Math.max(maxDiff, cur - diff);
            }
        }
        return (int)((s - maxDiff) % mod);
    }
}