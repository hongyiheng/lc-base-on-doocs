class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        int[] arr = new int[201];
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int index = nums[i] + 100;
            arr[index] += 1;
        }
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < 201; j++) {
                if (arr[j] != 0) {
                    arr[j] -= 1;
                    int index = -1 * (j - 100) + 100;
                    arr[index] += 1;
                    j = 201;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < 201; i++) {
            res += arr[i] * (i - 100);
        }
        return res;
    }
}