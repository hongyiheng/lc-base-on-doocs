class Solution {
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        Set<Integer> s = new HashSet<>();
        for (int i = n - 1; i > -1; i--) {
            if (s.contains(nums[i])) {
                return i / 3 + 1;
            }
            s.add(nums[i]);
        }
        return 0;
    }
}