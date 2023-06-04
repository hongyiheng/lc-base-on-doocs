class Solution {
    public int distinctAverages(int[] nums) {
        Set<Double> ans = new HashSet<>();
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;
        while (l < r) {
            ans.add((nums[l++] + nums[r--]) * 0.5);
        }
        return ans.size();
    }
}