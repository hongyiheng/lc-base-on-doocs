class Solution {
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int v : nums) {
            mp.put(v, mp.getOrDefault(v, 0) + 1);
        }
        int ans = 0;
        for (int v : mp.keySet()) {
            if (k == 0) {
                if (mp.get(v) > 1) {
                    ans++;
                }
            } else if (mp.containsKey(v + k)) {
                ans++;
            }
        }
        return ans;
    }
}
