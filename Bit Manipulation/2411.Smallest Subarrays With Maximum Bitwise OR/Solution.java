class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int[] ids = new int[32];
        for (int i = n - 1; i > -1; i--) {
            int r = i;
            for (int j = 0; j < 32; j++) {
                if ((nums[i] & (1 << j)) != 0) {
                    ids[j] = i;
                }
                r = Math.max(r, ids[j]);
            }
            ans[i] = r - i + 1;
        }
        return ans;
    }
}
