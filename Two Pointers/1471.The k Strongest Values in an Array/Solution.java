class Solution {
    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;
        int mid = arr[(n - 1) / 2];
        int[] ans = new int[k];
        int l = 0, r = n - 1;
        for (int i = 0; i < k; i++) {
            if (Math.abs(arr[r] - mid) >= Math.abs(arr[l] - mid)) {
                ans[i] = arr[r--];
            } else {
                ans[i] = arr[l++];
            }
        }
        return ans;
    }
}
