class Solution {
    public int findTheWinner(int n, int k) {
        int[] nums = new int[n + 1];
        Arrays.fill(nums, 1);
        nums[0] = 0;
        int idx = 1, step = 0, left = n;
        while (left > 1) {
            if (nums[idx] == 1) {
                step++;
            }
            if (step == k) {
                step = 0;
                nums[idx] = 0;
                left--;
            }
            idx = idx == n ? 1 : idx + 1;
        }
        for (int i = 0; i < n + 1; i++) {
            if (nums[i] == 1) {
                return i;
            }
        }
        return 1;
    }
}