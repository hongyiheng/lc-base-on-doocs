class Solution {
    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        int minVal = nums[0] * 2;
        for (int v : nums) {
            if (v % 2 != 0) {
                v *= 2;
            }
            minVal = Math.min(minVal, v);
            q.add(v);
        }
        int ans = Integer.MAX_VALUE;
        while (q.peek() % 2 == 0) {
            int v = q.poll();
            v /= 2;
            minVal = Math.min(minVal, v);
            q.add(v);
            ans = Math.min(ans, q.peek() - minVal);
        }
        return ans;
    }
}
