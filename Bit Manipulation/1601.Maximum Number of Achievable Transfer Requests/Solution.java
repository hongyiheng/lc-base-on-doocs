class Solution {
    public int maximumRequests(int n, int[][] requests) {
        int ans = 0, m = requests.length;
        for (int i = 0; i < (1 << m); i++) {
            int chooseNum = Integer.bitCount(i);
            if (chooseNum <= ans) {
                continue;
            }
            int[] cnt = new int[n];
            for (int k = 0; k < m; k++) {
                if ((i & (1 << k)) != 0) {
                    cnt[requests[k][0]]++;
                    cnt[requests[k][1]]--;
                }
            }
            if (check(cnt)) {
                ans = chooseNum;
            }
        }
        return ans;
    }

    public boolean check(int[] cnt){
        for (int v : cnt) {
            if (v != 0) {
                return false;
            }
        }
        return true;
    }
}