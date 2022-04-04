class Solution {
    public int countNegatives(int[][] grid) {
        int ans = 0;
        int n = grid[0].length;
        for (int[] row : grid) {
            int left = 0, right = n - 1;
            while (left < right) {
                int mid = (left + right) >> 1;
                if (row[mid] >= 0) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            if (row[left] < 0) {
                ans += n - left;
            }
        }
        return ans;
    }
}