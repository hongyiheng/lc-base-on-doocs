class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int[] cnt = new int[1010];
        for (int v : arr1) {
            cnt[v]++;
        }
        int[] ans = new int[n];
        int idx = 0;
        for (int v : arr2) {
            while (cnt[v]-- > 0) {
                ans[idx++] = v;
            }
        }
        for (int i = 0; i < 1010; i++) {
            while (cnt[i]-- > 0) {
                ans[idx++] = i;
            }
        }
        return ans;
    }
}