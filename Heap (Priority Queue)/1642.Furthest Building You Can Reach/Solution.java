class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        int n = heights.length, cnt = 0, useLadders = 0;
        for (int i = 1; i < n; i++) {
            if (heights[i - 1] >= heights[i]) {
                continue;
            }
            int gap = heights[i] - heights[i - 1];
            q.add(gap);
            cnt += gap;
            if (cnt > bricks) {
                if (useLadders < ladders) {
                    useLadders++;
                    cnt -= q.poll();
                } else {
                    return i - 1;
                }
            }
        }
        return n - 1;
    }
}