class Solution {
    int n;

    public int movesToMakeZigzag(int[] nums) {
        int[] nums2 = nums.clone();
        int ans = 0, ans2 = 0;
        n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                ans += decr(i, nums);
            } else {
                ans2 += decr(i, nums2);
            }
        }
        return Math.min(ans, ans2);
    }

    public int decr(int idx, int[] arr) {
        int ans = 0;
        if (idx > 0 && arr[idx] >= arr[idx - 1]) {
            ans += arr[idx] - arr[idx - 1] + 1;
            arr[idx] = arr[idx - 1] - 1;
        }
        if (idx < n - 1 && arr[idx] >= arr[idx + 1]) {
            ans += arr[idx] - arr[idx + 1] + 1;
            arr[idx] = arr[idx + 1] - 1;
        }
        return ans;
    }
}
