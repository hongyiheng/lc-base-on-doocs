class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int num : nums) {
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        }
        List<Integer> keys = new ArrayList<>(cnt.keySet());
        Collections.sort(keys);
        int ans = 0;
        int last = -0x3f3f3f3f;
        for (int k : keys) {
            if (k - last == 1) {
                ans = Math.max(ans, cnt.get(k) + cnt.get(last));
            }
            last = k;
        }
        return ans;
    }
}