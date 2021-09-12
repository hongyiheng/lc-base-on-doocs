class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        int ans = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (mp.containsKey(nums[i])) {
                ans += mp.get(nums[i]);
                mp.put(nums[i], mp.get(nums[i]) + 1);
            } else {
                mp.put(nums[i], 1);
            }
        }
        return ans;
    }
}