class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        List<int[]> q = new ArrayList<>();
        for (int i = 0; i < values.length; i++) {
            q.add(new int[]{values[i], labels[i]});
        }
        q.sort((a, b) -> b[0] - a[0]);
        Map<Integer, Integer> cnt = new HashMap<>();
        int ans = 0;
        for (int[] v : q) {
            if (numWanted <= 0) {
                break;
            }
            if (cnt.getOrDefault(v[1], 0) < useLimit) {
                ans += v[0];
                cnt.put(v[1], cnt.getOrDefault(v[1], 0) + 1);
                numWanted--;
            }
        }
        return ans;
    }
}
