class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int v : nums) {
            mp.put(v, mp.getOrDefault(v, 0) + 1);
        }
        int ans = 0;
        for (int k : mp.keySet()) {
            if (mp.containsKey(k + 1)) {
                ans = Math.max(ans, mp.get(k + 1) + mp.get(k));
            }
        }
        return ans;
    }
}
