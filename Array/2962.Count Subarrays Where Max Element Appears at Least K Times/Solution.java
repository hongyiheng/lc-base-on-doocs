class Solution {
    public long countSubarrays(int[] nums, int k) {
        int mx = Arrays.stream(nums).max().getAsInt();
        long ans = 0;
        int l = 0, cnt = 0;
        for (int v : nums) {
            if (v == mx) {
                cnt++;
            }
            while (cnt >= k) {
                if (nums[l++] == mx) {
                    cnt--;
                }
            }
            ans += l;
        }
        return ans;
    }
}