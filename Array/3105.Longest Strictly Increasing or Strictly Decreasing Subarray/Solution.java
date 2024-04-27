class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        List<Integer> up = new ArrayList<>(), down = new ArrayList<>();
        int ans = 0;
        for (int v : nums) {
            if (!up.isEmpty() && up.get(up.size() - 1) >= v) {
                up.clear();
            }
            if (!down.isEmpty() && down.get(down.size() - 1) <= v) {
                down.clear();
            }
            up.add(v);
            down.add(v);
            ans = Math.max(ans, Math.max(up.size(), down.size()));
        }
        return ans;
    }
}