class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> res = new ArrayList<>();
        int m = groupSizes.length;
        for (int i = 0; i < m; i++) {
            if (groupSizes[i] == -1) {
                continue;
            }
            int cur = groupSizes[i];
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                if (temp.size() >= cur) {
                    j = m;
                    continue;
                }
                if (groupSizes[j] == cur) {
                    temp.add(j);
                    groupSizes[j] = -1;
                }
            }
            res.add(temp);
        }
        return res;
    }

}