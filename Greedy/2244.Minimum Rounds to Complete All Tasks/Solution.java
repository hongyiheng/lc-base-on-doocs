class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int v : tasks) {
            cnt.put(v, cnt.getOrDefault(v, 0) + 1);
        }
        int ans = 0;
        for (int v : cnt.values()) {
            if (v == 1) {
                return -1;
            }
            ans += ((v + 2) / 3);
        }
        return ans;
    }
}