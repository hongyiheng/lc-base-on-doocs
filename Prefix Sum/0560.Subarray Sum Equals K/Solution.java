class Solution {
    public int subarraySum(int[] nums, int k) {
        int cur = 0, n = nums.length, ans = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        for (int i = 0; i < n; i++) {
            cur += nums[i];
            if (mp.containsKey(cur - k)) {
                ans += mp.get(cur - k);
            }
            mp.put(cur, mp.getOrDefault(cur, 0) + 1);
        }
        return ans;
    }
}