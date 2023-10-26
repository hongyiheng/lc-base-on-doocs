class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        Map<String, Integer>[] ts = new HashMap[510];
        Set<String> fs = new HashSet<>();
        for (List<String> o : orders) {
            int t = Integer.parseInt(o.get(1));
            String f = o.get(2);
            if (ts[t] == null) {
                ts[t] = new HashMap<>();
            }
            fs.add(f);
            ts[t].put(f, ts[t].getOrDefault(f, 0) + 1);
        }
        List<List<String>> ans = new ArrayList<>();
        List<String> fsList = new ArrayList<>(fs);
        Collections.sort(fsList);
        for (int i = 0; i < 510; i++) {
            if (ts[i] == null) {
                continue;
            }
            List<String> t = new ArrayList<>();
            t.add(String.valueOf(i));
            for (String f : fsList) {
                t.add(String.valueOf(ts[i].getOrDefault(f, 0)));
            }
            ans.add(t);
        }
        fsList.add(0, "Table");
        ans.add(0, fsList);
        return ans;
    }
}