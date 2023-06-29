class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        int n = colsum.length;
        int[][] ans = new int[2][n];
        for (int i = 0; i < n; i++) {
            if (colsum[i] == 2) {
                if (--upper < 0 || --lower < 0) {
                    return new ArrayList<>();
                }
                ans[0][i] = ans[1][i] = 1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (colsum[i] == 1) {
                if (upper > 0) {
                    ans[0][i] = 1;
                    --upper;
                } else if (lower > 0) {
                    ans[1][i] = 1;
                    --lower;
                } else {
                    return new ArrayList<>();
                }
            }
        }
        return upper == 0 && lower == 0 ?
                Arrays.stream(ans).map(e -> Arrays.stream(e).boxed().collect(Collectors.toList())).collect(Collectors.toList()) :
                new ArrayList<>();
    }
}