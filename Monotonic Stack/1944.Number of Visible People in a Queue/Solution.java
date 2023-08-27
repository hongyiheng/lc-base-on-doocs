class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        int[] ans = new int[n];
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = n - 1; i > -1; i--) {
            int h = heights[i];
            int cnt = 0;
            while (!q.isEmpty() && q.peekLast() < h) {
                cnt++;
                q.pollLast();
            }
            ans[i] = !q.isEmpty() ? cnt + 1 : cnt;
            q.addLast(h);
        }
        return ans;
    }
}