class Solution {
    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue<int[]> stk = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        int n = apples.length, cur = 0, ans = 0;
        while (cur < n) {
            if (apples[cur] > 0) {
                stk.offer(new int[]{cur + days[cur], apples[cur]});
            }
            while (!stk.isEmpty() && (stk.peek()[1] == 0 || stk.peek()[0] <= cur)) {
                stk.poll();
            }
            if (!stk.isEmpty()) {
                stk.peek()[1]--;
                ans++;
            }
            cur++;
        }
        while (!stk.isEmpty()) {
            while (!stk.isEmpty() && (stk.peek()[1] == 0 || stk.peek()[0] <= cur)) {
                stk.poll();
            }
            if (!stk.isEmpty()) {
                stk.peek()[1]--;
                ans++;
            }
            cur++;
        }
        return ans;
    }
}