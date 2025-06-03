class Solution {

    public String findCommonResponse(List<List<String>> responses) {
        int mx = 1;
        List<String> mxW = new ArrayList<>();
        Map<String, Integer> g = new HashMap<>();
        for (List<String> r : responses) {
            Set<String> s = new HashSet<>(r);
            for (String w : s) {
                g.put(w, g.getOrDefault(w, 0) + 1);
                if (mx < g.get(w)) {
                    mx = g.get(w);
                    mxW.clear();
                }
                if (mx == g.get(w)) {
                    mxW.add(w);
                }
            }
        }
        Collections.sort(mxW);
        return mxW.get(0);
    }
}
