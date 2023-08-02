class Solution {
    public int flipgame(int[] fronts, int[] backs) {
        int M = 2010;
        int[] cnt = new int[M];
        for (int i = 0; i < fronts.length; i++) {
            int a = fronts[i], b = backs[i];
            if (a == b) {
                cnt[a] = -1;
            }
            cnt[a] = cnt[a] == -1 ? -1 : 1;
            cnt[b] = cnt[b] == -1 ? -1 : 1;
        }
        for (int i = 0; i < M; i++) {
            if (cnt[i] == 1) {
                return i;
            }
        }
        return 0;
    }
}