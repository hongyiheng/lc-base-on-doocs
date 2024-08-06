class Solution {
    public int maxmiumScore(int[] cards, int cnt) {
        Arrays.sort(cards);
        int ans = 0;
        int odd = 2, even = 1;
        for (int i = cards.length - 1; i > -1; i--) {
            int v = cards[i];
            if (cnt > 0) {
                if (v % 2 == 0) {
                    even = v;
                } else {
                    odd = v;
                }
                ans += v;
                cnt--;
            } else if (ans % 2 == 1) {
                if (v % 2 == 0 && (ans - odd + v) % 2 == 0) {
                    return ans - odd + v;
                } else if (v % 2 == 1 && (ans - even + v) % 2 == 0) {
                    return ans - even + v;
                }
            }
        }
        return ans % 2 == 0 ? ans : 0;
    }
}