class Solution {
    public int getWinner(int[] arr, int k) {
        int mx = arr[0], cur = arr[0], cnt = 0;
        for (int i = 1; i < arr.length; i++) {
            if (cur >= arr[i]) {
                cnt++;
            } else {
                mx = arr[i];
                cur = arr[i];
                cnt = 1;
            }
            if (cnt >= k) {
                return cur;
            }
        }
        return mx;
    }
}