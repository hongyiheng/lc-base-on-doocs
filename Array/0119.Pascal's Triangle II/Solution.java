class Solution {
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) {
            return Arrays.asList(1);
        }
        List<Integer> q = Arrays.asList(1, 1);
        while (q.size() < rowIndex + 1) {
            List<Integer> nq = new ArrayList<>();
            nq.add(1);
            for (int i = 1; i < q.size(); i++) {
                nq.add(q.get(i - 1) + q.get(i));
            }
            nq.add(1);
            q = nq;
        }
        return q;
    }
}