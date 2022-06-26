class Solution {
    public int numOfPairs(String[] nums, String target) {
        Map<String, Integer> mp = new HashMap<>();
        int n = target.length(), ans = 0;
        for (String w : nums) {
            mp.put(w, mp.getOrDefault(w, 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            String pre = target.substring(0, i), tail = target.substring(i);
            int preNum = mp.getOrDefault(pre, 0);
            if (!pre.equals(tail)) {
                ans += preNum * mp.getOrDefault(tail, 0);
            } else {
                ans += preNum * (preNum - 1);
            }
        }
        return ans;
    }
}