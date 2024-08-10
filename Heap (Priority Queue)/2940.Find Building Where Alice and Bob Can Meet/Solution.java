class Solution {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n = queries.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        PriorityQueue<int[]> qs = new PriorityQueue<>((a, b) -> b[0] != a[0] ? a[0] - b[0] : a[1] - b[1]);
        for (int i = 0; i < n; i++) {
            int[] v = queries[i];
            Arrays.sort(v);
            int j = v[0], k = v[1];
            if (j == k) {
                ans[i] = j;
            } else if (heights[j] < heights[k]) {
                ans[i] = k;
            } else if (heights[j] >= heights[k]) {
                qs.add(new int[] {k, heights[j] + 1, i});
            }
        }

        PriorityQueue<int[]> hs = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < heights.length; i++) {
            while (!qs.isEmpty() && qs.peek()[0] <= i) {
                hs.add(new int[] {qs.peek()[1], qs.poll()[2]});
            }
            while (!hs.isEmpty() && hs.peek()[0] <= heights[i]) {
                ans[hs.poll()[1]] = i;
            }
        }

        return ans;
    }
}