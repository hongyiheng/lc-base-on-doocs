class Solution {

    Map<String, List<String>> g;
    int n;

    public List<String> dfs(Deque<String> path) {
        if (path.size() == n + 1) {
            return new ArrayList<>(path);
        }
        List<String> ans = null;
        String u = path.peekLast();
        List<String> vs = new ArrayList<>(g.getOrDefault(u, new ArrayList<>()));
        Collections.sort(vs);
        for (String v : vs) {
            g.get(u).remove(v);
            path.addLast(v);
            ans = dfs(path);
            if (ans != null) {
                break;
            }
            path.pollLast();
            g.get(u).add(v);
        }
        return ans;
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        n = tickets.size();
        g = new HashMap<>();
        for (List<String> uv : tickets) {
            String u = uv.get(0), v = uv.get(1);
            g.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        }
        Deque<String> path = new ArrayDeque<>();
        path.addLast("JFK");
        return dfs(path);
    }
}