class Solution {
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> g = new HashMap<>();
        int n = nums.length, ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                ans += g.getOrDefault(0, nums[i] * nums[j]) * 8;
                g.put(nums[i] * nums[j], g.getOrDefault(0, nums[i] * nums[j]) + 1);
            }
        }
        return ans;
    }
}