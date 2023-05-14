class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int cur = 0;
        for (int i = 0; i < k; i++) {
            cur += arr[i];
        }
        int ans = cur / k >= threshold ? 1 : 0;
        for (int i = k; i < arr.length; i++) {
            cur -= arr[i - k];
            cur += arr[i];
            if (cur / k >= threshold) {
                ans++;
            }
        }
        return ans;
    }
}