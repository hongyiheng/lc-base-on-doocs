class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stk = new LinkedList<>();
        int n = temperatures.length;
        int[] res = new int[n];
        for (int i = 0; i < n; ++i) {
            while (!stk.isEmpty() && temperatures[stk.peekLast()] < temperatures[i]) {
                int j = stk.pollLast();
                res[j] = i - j;
            }
            stk.offerLast(i);
        }
        return res;
    }
}