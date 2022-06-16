class Solution {
    public void duplicateZeros(int[] arr) {
        int n = arr.length;
        int cnt = 0;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                cnt++;
            } else if (i + cnt < n) {
                ans[i + cnt] = arr[i];
            }
        }
        for (int i = 0; i < n; i++) {
            arr[i] = ans[i];
        }
    }
}