class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!q.isEmpty() && temperatures[q.peekLast()] < temperatures[i]) {
                int j = q.pollLast();
                ans[j] = i - j;
            }
            q.offer(i);
        }
        return ans;
    }
}