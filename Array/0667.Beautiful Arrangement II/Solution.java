class Solution {
    public int[] constructArray(int n, int k) {
        int[] ans = new int[n];
        int l = 1, r = n, idx = 0;
        while (idx < k) {
            if (idx % 2 == 0) {
                ans[idx] = l++;
            } else {
                ans[idx] = r--;
            }
            idx++;
        }
        while (idx < n) {
            if (k % 2 == 0) {
                ans[idx++] = r--;
            } else {
                ans[idx++] = l++;
            }
        }
        return ans;
    }
}