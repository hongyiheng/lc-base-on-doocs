class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> ans = new ArrayList<>();
        int m = firstList.length, n = secondList.length;
        int i = 0, j = 0;
        while (i < m && j < n) {
            int a = firstList[i][0], b = firstList[i][1];
            int c = secondList[j][0], d = secondList[j][1];
            int l = Math.max(a, c), r = Math.min(b, d);
            if (l <= r) {
                ans.add(new int[]{l, r});
            }
            if (d > b) {
                i++;
            } else {
                j++;
            }
        }
        int[][] res = new int[ans.size()][2];
        for (int k = 0; k < ans.size(); k++) {
            res[k] = ans.get(k);
        }
        return res;
    }
}
