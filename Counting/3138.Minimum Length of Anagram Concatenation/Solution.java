class Solution {
    public boolean check(int[][] pre, int x) {
        int[] t = pre[x];
        for (int i = x * 2; i < pre.length; i += x) {
            for (int j = 0; j < 26; j++) {
                if (pre[i][j] - pre[i - x][j] != t[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public int minAnagramLength(String s) {
        int n = s.length();
        int[][] pre = new int[n + 1][26];
        for (int i = 0; i < n; i++) {
            int idx = s.charAt(i) - 'a';
            pre[i + 1] = pre[i].clone();
            pre[i + 1][idx]++;
        }
        for (int i = 1; i < n + 1; i++) {
            if (n % i != 0) {
                continue;
            }
            if (check(pre, i)) {
                return i;
            }
        }
        return -1;
    }
}