class Solution {

    int ans;
    int[] arr;

    public void dfs(int v, int mask) {
        if (mask == (1 << 4) - 1) {
            if (v / 100 < 24 && v % 100 < 60) {
                ans = Math.max(ans, v);
            }
            return;
        }
        for (int i = 0; i < 4; i++) {
            if ((mask >> i & 1) == 0) {
                dfs(v * 10 + arr[i], mask | 1 << i);
            }
        }
    }

    public String largestTimeFromDigits(int[] arr) {
        this.arr = arr;
        ans = -1;
        dfs(0, 0);
        if (ans == -1) {
            return "";
        }
        String h = ans / 100 >= 10 ? String.valueOf(ans / 100) : "0" + ans / 100;
        String m = ans % 100 >= 10 ? String.valueOf(ans % 100) : "0" + ans % 100;
        return h + ":" + m;
    }
}