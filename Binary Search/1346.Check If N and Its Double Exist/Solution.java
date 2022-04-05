class Solution {
    public boolean checkIfExist(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                int mid = (left + right) >> 1;
                if (arr[mid] < arr[i] * 2) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            if (left < n && left != i && arr[left] == arr[i] * 2) {
                return true;
            }
        }
        return false;
    }
}