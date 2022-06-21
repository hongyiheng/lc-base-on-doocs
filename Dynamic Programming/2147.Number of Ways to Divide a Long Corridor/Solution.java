class Solution {
    public int numberOfWays(String corridor) {
        int mod = (int)1e9 + 7;
        char[] chars = corridor.toCharArray();
        long ans = 0, sCnt = 0, pCnt = 0;
        for (char c : chars) {
            if (c == 'S' && ++sCnt % 2 == 0) {
                ans = ans == 0 ? 1 : ans;
                if (pCnt != 0) {
                    ans = ans * (pCnt + 1) % mod;
                    pCnt = 0;
                }
            }
            if (sCnt != 0 && sCnt % 2 == 0) {
                if (c == 'P') {
                    pCnt++;
                }
            }
        }
        return sCnt % 2 == 0 ? (int) ans % mod: 0;
    }
}