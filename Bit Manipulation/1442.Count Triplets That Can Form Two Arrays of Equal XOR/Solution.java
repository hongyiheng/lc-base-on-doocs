class Solution {
    public int countTriplets(int[] arr) {
        int n = arr.length;
        int ans = 0;
        for (int j = 0; j < n; j++) {
            int s = 0;
            for (int k = j; k < n; k++) {
                s ^= arr[k];
                if (s == 0) {
                    ans += k - j;
                }
            }
        }
        return ans;
    }
}