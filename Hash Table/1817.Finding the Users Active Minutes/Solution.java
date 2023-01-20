class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer, Set<Integer>> mp = new HashMap<>();
        for (int[] log : logs) {
            mp.computeIfAbsent(log[0], q -> new HashSet<>()).add(log[1]);
        }
        int[] ans = new int[k];
        for (var v : mp.values()) {
            ans[v.size() - 1]++;
        }
        return ans;
    }
}