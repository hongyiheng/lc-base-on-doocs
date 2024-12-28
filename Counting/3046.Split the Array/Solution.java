class Solution {
    public boolean isPossibleToSplit(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        int mx = 0;
        for (int v : nums) {
            cnt.put(v, cnt.getOrDefault(v, 0) + 1);
            mx = Math.max(mx, cnt.get(v));
        }
        return mx < 3;
    }
}