class Solution {
    public List<String> findHighAccessEmployees(List<List<String>> access_times) {
        int n = access_times.size();
        List<Pair<String, Integer>> q = new ArrayList<>();
        for (List<String> at : access_times) {
            int t = Integer.valueOf(at.get(1).substring(0, 2)) * 60 + Integer.valueOf(at.get(1).substring(2, 4));
            q.add(new Pair<>(at.get(0), t));
        }
        Collections.sort(q, (a, b) -> a.getValue() - b.getValue());
        Set<String> ans = new HashSet<>();
        Map<String, Deque<Integer>> cnt = new HashMap<>();
        for (Pair<String, Integer> p : q) {
            String k = p.getKey();
            if (ans.contains(k)) {
                continue;
            }
            int t = p.getValue();
            Deque<Integer> ts = cnt.getOrDefault(k, new ArrayDeque<>());
            while (!ts.isEmpty() && ts.peekFirst() <= t - 60) {
                ts.pollFirst();
            }
            ts.add(t);
            if (ts.size() == 3) {
                ans.add(k);
            }
            cnt.put(k, ts);
        }
        return new ArrayList<>(ans);
    }
}