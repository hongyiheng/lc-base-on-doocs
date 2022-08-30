class Solution {
    public int[] dailyTemperatures(int[] t) {
        int n = t.length;
        int[] ans = new int[n];
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!q.isEmpty() && t[q.peekLast()] < t[i]) {
                int idx = q.pollLast();
                ans[idx] = i - idx;
            }
            q.addLast(i);
        }
        return ans;
    }
}