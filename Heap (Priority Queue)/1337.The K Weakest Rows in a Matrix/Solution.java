class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> cnt = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        for (int i = 0; i < mat.length; i++) {
            int[] row = mat[i];
            int left = 0, right = row.length;
            while (left < right) {
                int mid = (left + right) >> 1;
                if (row[mid] == 1) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            cnt.offer(new int[]{left, i});
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = cnt.poll()[1];
        }
        return ans;
    }
}