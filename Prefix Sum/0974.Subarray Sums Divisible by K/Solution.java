class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        int s = 0, ans = 0;
        mp.put(0, 1);
        for (int num : nums) {
            s += num;
            while (s < 0) {
                s += k;
            }
            int same = mp.getOrDefault(s % k, 0);
            ans += same;
            mp.put(s % k, same + 1);
        }
        return ans;
    }
}