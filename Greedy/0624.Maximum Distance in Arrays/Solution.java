class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int ans = 0;
        for (int i = 0; i < arrays.size(); i++) {
            List<Integer> cur = arrays.get(i);
            if (i > 0) {
                ans = Math.max(ans, Math.abs(cur.get(cur.size() - 1) - min));
                ans = Math.max(ans, Math.abs(max - cur.get(0)));
            }
            max = Math.max(max, cur.get(cur.size() - 1));
            min = Math.min(min, cur.get(0));
        }
        return ans;
    }
}