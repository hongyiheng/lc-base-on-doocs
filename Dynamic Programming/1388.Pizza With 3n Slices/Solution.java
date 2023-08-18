class Solution {

    int k;

    public int maxSizeSlices(int[] slices) {
        int n = slices.length;
        k = n / 3;
        int[] a = Arrays.copyOfRange(slices, 0, n - 1);
        int[] b = Arrays.copyOfRange(slices, 1, n);
        return Math.max(getMax(a), getMax(b));
    }

    public int getMax(int[] arr) {
        int m = arr.length;
        int[][] f = new int[m + 1][k + 1];
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < k + 1; j++) {
                f[i][j] = Math.max(f[i - 1][j], (i >= 2 ? f[i - 2][j - 1] : 0) + arr[i - 1]);
            }
        }
        return f[m][k];
    }
}