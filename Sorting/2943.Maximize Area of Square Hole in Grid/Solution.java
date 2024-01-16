class Solution {

    public int getMax(int[] arr) {
        Arrays.sort(arr);
        int ans = 0, cur = 1, cnt = 0;
        for (int v : arr) {
            if (v == cur + 1) {
                cnt++;
            } else {
                cnt = 1;
            }
            ans = Math.max(ans, cnt + 1);
            cur = v;
        }
        return ans;
    }

    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        int maxD = Math.min(getMax(hBars), getMax(vBars));
        return maxD * maxD;
    }
}