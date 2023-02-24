class Solution {
    public int minimumCardPickup(int[] cards) {
        Map<Integer, Integer> mp = new HashMap<>();
        int n = cards.length, ans = cards.length + 1;
        for (int i = 0; i < n; i++) {
            if (mp.containsKey(cards[i])) {
                ans = Math.min(ans, i - mp.get(cards[i]) + 1);
            }
            mp.put(cards[i], i);
        }
        return ans == n + 1 ? -1 : ans;
    }
}
