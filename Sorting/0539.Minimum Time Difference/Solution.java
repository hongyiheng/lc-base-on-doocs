class Solution {
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        if (n > 24 * 60) {
            return 0;
        }
        PriorityQueue<Integer> mins = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        int minTime = Integer.MAX_VALUE;
        for (String t : timePoints) {
            int hour = Integer.parseInt(t.split(":")[0]);
            int min = Integer.parseInt(t.split(":")[1]);
            mins.offer(hour * 60 + min);
            minTime = Math.min(minTime, hour * 60 + min);
        }
        mins.offer(minTime + 24 * 60);
        int ans = Integer.MAX_VALUE;
        int last = mins.poll();
        while (!mins.isEmpty()) {
            int cur = mins.poll();
            int diff = last - cur;
            ans = Math.min(ans, diff);
            last = cur;
        }
        return ans;
    }
}