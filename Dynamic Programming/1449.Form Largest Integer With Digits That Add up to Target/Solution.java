class Solution {
    public String largestNumber(int[] cost, int target) {
        int[] f = new int[target + 1];
        Arrays.fill(f, -0x3f3f3f3f);
        f[0] = 0;
        for (int i = 0; i <= target; i++) {
            for (int j = 0; j < 9; j++) {
                int c = cost[j];
                if (c > i) {
                    continue;
                }
                f[i] = Math.max(f[i], f[i - c] + 1);
            }
        }
        if (f[target] <= 0) {
            return "0";
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 9; i > 0; i--) {
            int c = cost[i - 1];
            while (target >= c && f[target - c] + 1 == f[target]) {
                ans.append(i);
                target -= c;
            }
        }
        return ans.toString();
    }
}