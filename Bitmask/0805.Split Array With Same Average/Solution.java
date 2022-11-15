class Solution {
    public boolean splitArraySameAverage(int[] nums) {
        int n = nums.length, m = n / 2, s = 0;
        if (n == 1) {
            return false;
        }
        for (int v : nums) {
            s += v;
        }
        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] * n - s;
        }
        Set<Integer> vis = new HashSet<>();
        for (int i = 1; i < (1 << m); i++) {
            int ss = 0;
            for (int j = 0; j < m; j++) {
                if (((1 << j) & i) != 0) {
                    ss += nums[j];
                }
            }
            if (ss == 0) {
                return true;
            }
            vis.add(ss);
        }
        for (int i = 1; i < (1 << (n - m)); i++) {
            int ss = 0;
            for (int j = 0; j < (n - m); j++) {
                if (((1 << j) & i) != 0) {
                    ss += nums[j + m];
                }
            }
            if (ss == 0 || (i != (1 << (n - m)) - 1 && vis.contains(-ss))) {
                return true;
            }
        }
        return false;
    }
}
