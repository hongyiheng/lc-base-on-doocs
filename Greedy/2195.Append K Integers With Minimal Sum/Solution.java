class Solution {
    public long minimalKSum(int[] nums, int k) {
        long ans = 1L * (k + 1) * k / 2;
        Set<Integer> s = new HashSet<>();
        for (int v : nums) {
            s.add(v);
        }
        int cur = k;
        for (int v : s) {
            if (v <= k) {
                cur++;
                while (s.contains(cur)) {
                    cur++;
                }
                ans = ans - v + cur;
            }
        }
        return ans;
    }
}