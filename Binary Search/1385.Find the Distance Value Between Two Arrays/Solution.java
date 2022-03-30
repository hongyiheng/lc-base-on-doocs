class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int ans = 0;
        for (int num : arr1) {
            int left = 0, right = arr2.length - 1;
            while (left < right) {
                int mid = (left + right) >> 1;
                if (arr2[mid] < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            if (Math.abs(num - arr2[left]) <= d) {
                continue;
            }
            left = 0;
            right = arr2.length - 1;
            while (left < right) {
                int mid = (left + right + 1) >> 1;
                if (arr2[mid] > num) {
                    right = mid - 1;
                } else {
                    left = mid;
                }
            }
            if (Math.abs(num - arr2[left]) <= d) {
                continue;
            }
            ans++;
        }
        return ans;
    }
}