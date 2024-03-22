class Solution {
    public int sumCounts(List<Integer> nums) {
        int n = nums.size(), MOD = (int)1e9 + 7;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> s = new HashSet<>();
            for (int j = i; j < n; j++) {
                s.add(nums.get(j));
                ans = (ans + (long)s.size() * s.size()) % MOD;
            }
        }
        return (int)ans;
    }
}