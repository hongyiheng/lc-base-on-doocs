class Solution {
    public int maxRemoval(int[] nums, int[][] queries) {
        Arrays.sort(queries, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] q = new int[nums.length + 1];
        int d = 0, pos = 0;
        for (int i = 0; i < nums.length; i++) {
            int v = nums[i];
            d += q[i];
            while (pos < queries.length && queries[pos][0] <= i) {
                pq.offer(-queries[pos][1]);
                pos++;
            }
            while (d < v && !pq.isEmpty() && -pq.peek() >= i) {
                d += 1;
                q[-pq.poll() + 1] -= 1;
            }
            if (v > d) {
                return -1;
            }
        }
        return pq.size();
    }
}