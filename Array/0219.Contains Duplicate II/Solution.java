class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> f = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (f.containsKey(nums[i]) && i - f.get(nums[i]) <= k) {
                return true;
            }
            f.put(nums[i], i);
        }
        return false;      
    }
}