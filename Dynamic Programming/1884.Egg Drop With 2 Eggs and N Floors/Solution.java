class Solution {
    public int twoEggDrop(int n) {
        int[] f = new int[n + 1];
        Arrays.fill(f, 0x3f3f3f3f);
        f[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j <= i; j++) {
                f[i] = Math.min(f[i], Math.max(f[i - j] + 1, j));
            }
        }
        return f[n];
    }
}