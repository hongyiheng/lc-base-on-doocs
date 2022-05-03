/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> info = binaryMatrix.dimensions();
        int m = info.get(0), n = info.get(1);
        int ans = -1;
        for (int i = 0; i < m; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                int mid = (left + right) >> 1;
                if (binaryMatrix.get(i, mid) == 0) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            if (binaryMatrix.get(i, left) == 1) {
                ans = ans == -1 ? left : Math.min(ans, left);
            }
        }
        return ans;
    }
}