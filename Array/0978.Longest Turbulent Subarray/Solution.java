class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        if (n == 0) {
            return 0;
        }
        int ans = 1, cnt = 1;
        for (int i = 1; i < n; i++) {
            if (i % 2 == 0 && arr[i] > arr[i - 1]) {
                cnt++;
            } else if (i % 2 == 1 && arr[i] < arr[i - 1]) {
                cnt++;
            } else {
                ans = Math.max(ans, cnt);
                cnt = 1;
            }
        }
        ans = Math.max(ans, cnt);
        cnt = 1;
        for (int i = 1; i < n; i++) {
            if (i % 2 == 0 && arr[i] < arr[i - 1]) {
                cnt++;
            } else if (i % 2 == 1 && arr[i] > arr[i - 1]) {
                cnt++;
            } else {
                ans = Math.max(ans, cnt);
                cnt = 1;
            }
        }
        ans = Math.max(ans, cnt);
        return ans;
    }
}