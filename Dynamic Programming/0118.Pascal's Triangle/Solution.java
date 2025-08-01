class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(Arrays.asList(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> last = ans.get(ans.size() - 1);
            List<Integer> cur = new ArrayList<>();
            for (int j = 0; j < last.size() + 1; j++) {
                if (j == 0 || j == last.size()) {
                    cur.add(1);
                } else {
                    cur.add(last.get(j - 1) + last.get(j));
                }
            }
            ans.add(cur);
        }
        return ans;
    }
}