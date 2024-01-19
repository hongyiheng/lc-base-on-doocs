class Solution {
    public int minimumTime(List<Integer> nums1, List<Integer> nums2, int x) {
        int n = nums1.size();
        int[][] q = new int[n][2];
        int s1 = 0, s2 = 0;
        for (int i = 0; i < n; i++) {
            int a = nums1.get(i), b = nums2.get(i);
            q[i][0] = a;
            q[i][1] = b;
            s1 += a;
            s2 += b;
        }
        Arrays.sort(q, (a, b) -> a[1] - b[1]);
        int[] f = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int a = q[i][0], b = q[i][1];
            for (int j = i + 1; j > 0; j--) {
                f[j] = Math.max(f[j], f[j - 1] + a + b * j);
            }
        }
        for (int i = 0; i < n + 1; i++) {
            if (s1 + s2 * i - f[i] <= x) {
                return i;
            }
        }
        return -1;
    }
}