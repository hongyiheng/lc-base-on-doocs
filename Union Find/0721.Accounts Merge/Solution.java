class Solution {
    Map<String, String> p = new HashMap<>();

    public String find(String x) {
        p.put(x, p.getOrDefault(x, x));
        if (!p.get(x).equals(x)) {
            p.put(x, find(p.get(x)));
        }
        return p.get(x);
    }

    public void union(String a, String b) {
        p.put(find(a), find(b));
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> emailName = new HashMap<>();
        for (List<String> ac : accounts) {
            for (int i = 1; i < ac.size(); i++) {
                emailName.put(ac.get(i), ac.get(0));
                p.put(ac.get(i), p.getOrDefault(ac.get(i), ac.get(i)));
                if (i > 1) {
                    union(ac.get(i - 1), ac.get(i));
                }
            }
        }
        Map<String, List<String>> g = new HashMap<>();
        for (String email : p.keySet()) {
            g.computeIfAbsent(find(email), k -> new ArrayList<>()).add(email);
        }
        List<List<String>> ans = new ArrayList<>();
        for (String k : g.keySet()) {
            List<String> tmp = new ArrayList<>(g.get(k));
            Collections.sort(tmp);
            tmp.add(0, emailName.get(k));
            ans.add(tmp);
        }
        return ans;
    }
}