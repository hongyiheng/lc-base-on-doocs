class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;
        int[][] ts = new int[n][3];
        PriorityQueue<Integer> ids = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            ts[i] = new int[]{times[i][0], times[i][1], i};
            ids.add(i);
        }
        Arrays.sort(ts, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<int[]> back = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (int[] v : ts) {
            while (!back.isEmpty() && back.peek()[0] <= v[0]) {
                ids.add(back.poll()[1]);
            }
            int id = ids.poll();
            if (v[2] == targetFriend) {
                return id;
            }
            back.add(new int[]{v[1], id});
        }
        return -1;
    }
}