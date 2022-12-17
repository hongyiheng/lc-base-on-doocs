class Solution {
    public int destroyTargets(int[] nums, int space) {
        Map<Integer, List<Integer>> mp = new HashMap<>();
        for (int v : nums) {
            mp.computeIfAbsent(v % space, k -> new ArrayList<>()).add(v);
        }
        int ans = Integer.MAX_VALUE, mx = 0;
        for (List<Integer> q : mp.values()) {
            if (q.size() >= mx) {
                int mi = Integer.MAX_VALUE;
                for (int v : q) {
                    mi = Math.min(v, mi);
                }
                if (q.size() > mx || (q.size() == mx && mi < ans)) {
                    ans = mi;
                }
                mx = q.size();
            }
        }
        return ans;
    }
}
