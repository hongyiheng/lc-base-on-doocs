class Solution {
    public int minOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 0, last = 0;
        for (int v : nums) {
            if (v < k) {
                return -1;
            } else if (v > k && v != last) {
                ans++;
            }
            last = v;
        }
        return ans;
    }
}