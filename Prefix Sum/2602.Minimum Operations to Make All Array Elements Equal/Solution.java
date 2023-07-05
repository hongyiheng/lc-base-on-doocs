class Solution {
    public List<Long> minOperations(int[] nums, int[] queries) {
        int n = nums.length;
        Arrays.sort(nums);
        long[] pre = new long[n + 1];
        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + nums[i];
        }
        List<Long> ans = new ArrayList<>();
        for (int t : queries) {
            int l = 0, r = n - 1;
            while (l < r) {
                int mid = (l + r) >> 1;
                if (nums[mid] < t) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            int k = nums[l] >= t ? l : l + 1;
            ans.add((long) t * k - pre[k] + pre[n] - pre[k] - (long) (n - k) * t);
        }
        return ans;
    }
}