class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length, right = n - 1;
        while (right > 0 && arr[right] >= arr[right - 1]) {
            right--;
        }
        if (right == 0) {
            return 0;
        }
        int ans = right;
        for (int left = 0; left < n; left++) {
            if (left > 0 && arr[left] < arr[left - 1]) {
                break;
            }
            while (right < n && arr[left] > arr[right]) {
                right++;
            }
            ans = Math.min(ans, right - left - 1);
        }
        return ans;
    }
}