class Solution {
    public int maxSum(int[] nums) {
        Set<Integer> s = new HashSet<>();
        int ans = nums[0];
        for (int v : nums) {
            if (v >= 0) {
                s.add(v);
            }
            ans = Math.max(ans, v);
        }
        return s.isEmpty() ? ans : s.stream().mapToInt(e -> e).sum();
    }
}