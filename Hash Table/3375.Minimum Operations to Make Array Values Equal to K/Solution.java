class Solution {
    public int minOperations(int[] nums, int k) {
        Set<Integer> s = new HashSet<>();
        for (int v : nums) {
            if (v > k) {
                s.add(v);
            } else if (v < k) {
                return -1;
            }
        }
        return s.size();
    }
}