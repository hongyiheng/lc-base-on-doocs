class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = nums2[i];
            arr[i][1] = i;
        }
        Arrays.sort(nums1);
        Arrays.sort(arr, (a, b) -> b[0] - a[0]);
        int l = 0, r = n - 1;
        int[] ans = new int[n];
        for (int[] v : arr) {
            if (v[0] < nums1[r]) {
                ans[v[1]] = nums1[r--];
            } else {
                ans[v[1]] = nums1[l++];
            }
        }
        return ans;
    }
}
