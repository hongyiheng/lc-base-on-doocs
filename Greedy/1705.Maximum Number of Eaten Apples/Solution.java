class Solution {
    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int ans = 0, i = 0, n = apples.length;
        while (i < n || !q.isEmpty()) {
            if (i < n && apples[i] != 0) {
                q.add(new int[]{i + days[i], apples[i]});
            }
            while (!q.isEmpty() && (q.peek()[0] <= i || q.peek()[1] == 0)) {
                q.poll();
            }
            if (!q.isEmpty()) {
                q.peek()[1]--;
                ans++;
            }
            i++;
        }
        return ans;
    }
}