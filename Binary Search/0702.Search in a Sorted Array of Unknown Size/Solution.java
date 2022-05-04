/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        int left = 0, right = 10000;
        while (left < right) {
            int mid = (left + right + 1) >> 1;
            if (reader.get(mid) <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return reader.get(left) == target ? left : -1;
    }
}