class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;
        for (int i = 0; i < n; i++) {
            int l = 0, r = n - 1;
            while (l < r) {
                int tmp = image[i][l];
                image[i][l] = image[i][r] ^ 1;
                image[i][r] = tmp ^ 1;
                l++;
                r--;
            }
            if (l == r) {
                image[i][l] ^= 1;
            }
        }
        return image;
    }
}
