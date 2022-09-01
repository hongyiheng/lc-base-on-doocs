class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        Deque<Integer> q = new ArrayDeque<>();
        int[] ans = new int[n];
        for (int i = n - 1; i > -1; i--) {
            int cur = prices[i];
            while (!q.isEmpty() && prices[q.peekFirst()] > prices[i]) {
                q.pollFirst();
            }
            if (!q.isEmpty()) {
                cur -= prices[q.peekFirst()];
            }
            ans[i] = cur;
            q.addFirst(i);
        }
        return ans;
    }
}