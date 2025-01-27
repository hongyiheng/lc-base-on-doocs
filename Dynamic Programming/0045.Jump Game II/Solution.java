class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }
        int[] f = new int[n];
        Arrays.fill(f, 0x3f3f3f3f);
        f[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < Math.min(i + nums[i] + 1, n); j++) {
                f[j] = Math.min(f[j], f[i] + 1);
            }
        }
        return f[n - 1];
    }
}