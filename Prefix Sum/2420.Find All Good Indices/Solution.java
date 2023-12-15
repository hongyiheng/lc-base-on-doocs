class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        int n = nums.length;
        int[] up = new int[n], down = new int[n];
        Arrays.fill(up, 1);
        Arrays.fill(down, 1);
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] >= nums[i]) {
                down[i] = down[i - 1] + 1;
            }
        }
        for (int i = n - 2; i > -1; i--) {
            if (nums[i] <= nums[i + 1]) {
                up[i] = up[i + 1] + 1;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i < n - 1; i++) {
            if (down[i - 1] >= k && up[i + 1] >= k) {
                ans.add(i);
            }
        }
        return ans;
    }
}