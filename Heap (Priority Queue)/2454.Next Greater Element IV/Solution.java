class Solution {
    public int[] secondGreaterElement(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < n; i++) {
            List<int[]> tmp = new ArrayList<>();
            while (!q.isEmpty() && q.peek()[0] < nums[i]) {
                tmp.add(q.poll());
            }
            for (int[] t : tmp) {
                int v = t[0], j = t[1], k = t[2];
                if (k == 1) {
                    ans[j] = nums[i];
                } else {
                    q.add(new int[]{v, j, k - 1});
                }
            }
            q.add(new int[]{nums[i], i, 2});
        }
        return ans;
    }
}