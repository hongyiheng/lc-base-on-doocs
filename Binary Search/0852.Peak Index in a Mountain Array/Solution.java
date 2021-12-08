class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = (left + right + 1) >> 1;
            if (arr[mid] >= arr[mid - 1]) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}