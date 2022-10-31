class Solution {
    public int magicalString(int n) {
        int[] nums = new int[n + 2];
        nums[0] = 1;
        nums[1] = 2;
        nums[2] = 2;
        int ans = 0, cur = 2;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                int v = nums[i - 1] == 2 ? 1 : 2;
                nums[i] = v;
                if (nums[cur] == 2) {
                    nums[i + 1] = v;
                }
                cur++;
            }
            if (nums[i] == 1) {
                ans++;
            }
        }
        return ans;
    }
}
