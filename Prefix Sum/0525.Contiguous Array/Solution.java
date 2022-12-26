class Solution {
    public int findMaxLength(int[] nums) {
        int cur = 0, ans = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                cur++;
            } else {
                cur--;
            }
            if (mp.containsKey(cur)) {
                ans = Math.max(ans, i - mp.get(cur));
            } else {
                mp.put(cur, i);
            }
        }
        return ans;
    }
}