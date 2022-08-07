class Solution {
    public int minimumOperations(int[] nums) {
        Set<Integer> ans = new HashSet<>();
        for (int v : nums) {
            if (v == 0) {
                continue;
            }
            ans.add(v);
        }
        return ans.size();
    }
}