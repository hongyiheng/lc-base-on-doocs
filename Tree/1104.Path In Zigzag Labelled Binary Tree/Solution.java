class Solution {
    public int getParent(int cur, int row) {
        int curMin = 1 << row, curMax = (1 << row + 1) - 1;
        int pMin = 1 << row - 1, pMax = (1 << row) - 1;
        if (row % 2 == 0) {
            int idx = curMax - cur;
            return pMin + idx / 2;
        } else {
            int idx = cur - curMin;
            return pMax - idx / 2;
        }
    }

    public List<Integer> pathInZigZagTree(int label) {
        int row = 0;
        while (label >= (1 << row)) {
            row++;
        }
        List<Integer> ans = new ArrayList<>();
        ans.add(label);
        while (label != 1) {
            label = getParent(label, --row);
            ans.add(label);
        }
        Collections.reverse(ans);
        return ans;
    }
}
