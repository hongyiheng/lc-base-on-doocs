class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        Set<Integer> s = new HashSet<>();
        for (int v : nums) {
            s.add(v);
        }
        int ans = 0;
        for (int v : nums) {
            if (s.contains(v + diff) && s.contains(v + 2 * diff)) {
                ans++;
            }
        }
        return ans;
    }
}
