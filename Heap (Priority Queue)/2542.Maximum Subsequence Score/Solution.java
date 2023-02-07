class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = nums1[i];
            arr[i][1] = nums2[i];
        }
        Arrays.sort(arr, (a, b) -> b[1] - a[1]);
        long s = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            q.add(arr[i][0]);
            s += arr[i][0];
        }
        long ans = s * arr[k - 1][1];
        for (int i = k; i < n; i++) {
            int v = arr[i][0];
            if (!q.isEmpty() && v > q.peek()) {
                s -= q.poll();
                q.add(v);
                s += v;
                ans = Math.max(ans, s * arr[i][1]);
            }
        }
        return ans;
    }
}