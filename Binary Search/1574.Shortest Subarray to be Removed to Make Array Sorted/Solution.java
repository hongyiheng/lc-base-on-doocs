class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int leftEnd = 0, rightStart = n - 1;
        while (leftEnd < n - 1 && arr[leftEnd] <= arr[leftEnd + 1]) {
            leftEnd++;
        }
        if (leftEnd == n - 1) {
            return 0;
        }
        while (rightStart > 1 && arr[rightStart] >= arr[rightStart - 1]) {
            rightStart--;
        }
        if (arr[leftEnd] < arr[rightStart]) {
            return rightStart - leftEnd - 1;
        }
        int ans = Math.min(rightStart, n - leftEnd - 1);
        for (int i = 0; i <= leftEnd; i++) {
            int left = rightStart, right = n - 1;
            while (left < right) {
                int mid = (left + right) >> 1;
                if (arr[mid] >= arr[i]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            if (arr[left] < arr[i]) {
                break;
            }
            ans = Math.min(ans, left - i - 1);
        }
        return ans;
    }
}