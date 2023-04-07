class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> cnt = new HashMap<>();
        int ans = 0;
        for (int t : time) {
            int o = 60 - t % 60;
            ans += cnt.getOrDefault(o == 60 ? 0 : o, 0);
            cnt.put(t % 60, cnt.getOrDefault(t % 60, 0) + 1);
        }
        return ans;
    }
}
