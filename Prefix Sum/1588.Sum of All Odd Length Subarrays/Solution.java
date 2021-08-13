class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length;
        int[] presum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            presum[i] = presum[i - 1] + arr[i - 1];
        }

        int res = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j += 2) {
                res += presum[j] - presum[i - 1];
            }
        }
        return res;
    }
}