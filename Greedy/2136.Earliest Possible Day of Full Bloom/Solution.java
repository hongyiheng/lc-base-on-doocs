class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < plantTime.length; i++) {
            q.add(new int[]{plantTime[i], growTime[i]});
        }
        int idx = 0, ans = 0;;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            idx += cur[0];
            ans = Math.max(idx + cur[1], ans);
        }
        return ans;
    }
}