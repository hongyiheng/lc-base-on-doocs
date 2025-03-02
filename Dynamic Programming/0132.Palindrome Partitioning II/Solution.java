class Solution {

    String s;
    int[] f1 = new int[2010];
    Boolean[][] f2 = new Boolean[2010][2010];

    private boolean check(int l, int r) {
        if (l >= r) {
            return true;
        }
        if (f2[l][r] != null) {
            return f2[l][r];
        }
        boolean res = s.charAt(l) == s.charAt(r) && check(l + 1, r - 1);
        f2[l][r] = res;
        return f2[l][r];
    }

    private int dfs(int r) {
        if (check(0, r)) {
            return 0;
        }
        if (f1[r] != -1) {
            return f1[r];
        }
        int res = 0x3f3f3f3f;
        for (int l = 1; l < r + 1; l++) {
            if (check(l, r)) {
                res = Math.min(res, dfs(l - 1) + 1);
            }
        }
        f1[r] = res;
        return res;
    }

    public int minCut(String s) {
        this.s = s;
        Arrays.fill(f1, -1);
        return dfs(s.length() - 1);
    }
}