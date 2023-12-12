class Solution {
    public long countSubarrays(int[] nums, int k) {
        int mx = Arrays.stream(nums).max().getAsInt();
        int l = 0, r = 0, cnt = 0;
        long ans = 0;
        while (r < nums.length) {
            if (nums[r] == mx) {
                cnt++;
            }
            while (cnt >= k) {
                if (nums[l] == mx) {
                    cnt--;
                }
                l++;
            }
            ans += l;
            r++;
        }
        return ans;
    }
}