class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        Pair<Integer, String>[] q = new Pair[n];
        for (int i = 0; i < n; i++) {
            q[i] = new Pair<>(heights[i], names[i]);
        }
        Arrays.sort(q, (a, b) -> b.getKey() - a.getKey());
        String[] ans = new String[n];
        for (int i = 0; i < n; i++) {
            ans[i] = q[i].getValue();
        }
        return ans;
    }
}
