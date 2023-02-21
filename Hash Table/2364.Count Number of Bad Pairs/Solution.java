class Solution {
    public long countBadPairs(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int d = i - nums[i];
            ans += i - mp.getOrDefault(d, 0);
            mp.put(d, mp.getOrDefault(d, 0) + 1);
        }
        return ans;
    }
}
