class Solution {
    public int minSubarray(int[] nums, int p) {
        int ans = nums.length, n = nums.length;
        int pre[] = new int[n + 1];
        int k = 0;
        for (int num : nums) {
            k = (k + num) % p;
        }
        for (int i = 1; i <= nums.length; i++) {
            pre[i] = (pre[i - 1] + nums[i - 1]) % p;
        }
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i <= nums.length; i++) {
            mp.put(pre[i], i);
            int x = (pre[i] - k + p) % p;
            if (mp.containsKey(x)) {
                ans = Math.min(ans, i - mp.get(x));
            }
        }
        return ans == n ? -1 : ans;
    }
}