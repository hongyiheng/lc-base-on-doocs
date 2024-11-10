class Solution {
    public int rampartDefensiveLine(int[][] rampart) {
        int l = 0, r = rampart[rampart.length - 1][0] - rampart[0][1];
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (check(mid, rampart)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }

    public boolean check(int x, int[][] rampart) {
        int n = rampart.length;
        int last = -0x3f3f3f3f;
        for (int i = 0; i < n - 1; i++) {
            int l = rampart[i][0], r = rampart[i][1];
            if (l - last + rampart[i + 1][0] - r < x) {
                return false;
            }
            last = Math.max(r, r + x - l + last);
        }
        return true;
    }
}