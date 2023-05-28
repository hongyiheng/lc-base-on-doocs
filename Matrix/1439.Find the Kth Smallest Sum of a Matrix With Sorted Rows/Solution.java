class Solution {
    public int kthSmallest(int[][] mat, int k) {
        List<Integer> pre = new ArrayList<>();
        pre.add(0);
        for (int[] row : mat) {
            List<Integer> q = new ArrayList<>();
            for (int a : pre) {
                for (int b : row) {
                    q.add(a + b);
                }
            }
            Collections.sort(q);
            pre.clear();
            for (int p = 0; p < Math.min(k, q.size()); p++) {
                pre.add(q.get(p));
            }
        }
        return pre.get(k - 1);
    }
}