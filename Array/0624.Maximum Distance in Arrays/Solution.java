class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int mi = arrays.get(0).get(0), mx = arrays.get(0).get(arrays.get(0).size() - 1);
        int ans = 0;
        for (int i = 1; i < arrays.size(); i++) {
            int l = arrays.get(i).get(0), r = arrays.get(i).get(arrays.get(i).size() - 1);
            ans = Math.max(ans, Math.abs(mx - l));
            ans = Math.max(ans, Math.abs(r - mi));
            mx = Math.max(mx, r);
            mi = Math.min(mi, l);
        }
        return ans;
    }
}