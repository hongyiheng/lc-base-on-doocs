class Solution {
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        Map<String, long[]> mp = new HashMap<>();
        int n = creators.length;
        for (int i = 0; i < n; i++) {
            long[] cur = mp.getOrDefault(creators[i], new long[]{-1, 0, 0});
            if (cur[0] == -1 || cur[1] < views[i] || (cur[1] == views[i] && ids[(int) cur[0]].compareTo(ids[i]) > 0)) {
                cur[0] = i;
                cur[1] = views[i];
            }
            cur[2] += views[i];
            mp.put(creators[i], cur);
        }
        List<List<String>> ans = new ArrayList<>();
        long mx = 0;
        for (Map.Entry<String, long[]> entry : mp.entrySet()) {
            long[] cur = entry.getValue();
            if (cur[2] > mx) {
                mx = cur[2];
                ans.clear();
                ans.add(Arrays.asList(entry.getKey(), ids[(int) cur[0]]));
            } else if (cur[2] == mx) {
                ans.add(Arrays.asList(entry.getKey(), ids[(int) cur[0]]));
            }
        }
        return ans;
    }
}
