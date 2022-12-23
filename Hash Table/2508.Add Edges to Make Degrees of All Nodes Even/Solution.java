class Solution {
    public boolean isPossible(int n, List<List<Integer>> edges) {
        Map<Integer, Set<Integer>> mp = new HashMap<>();
        for (List<Integer> e : edges) {
            mp.computeIfAbsent(e.get(0), k -> new HashSet<>()).add(e.get(1));
            mp.computeIfAbsent(e.get(1), k -> new HashSet<>()).add(e.get(0));
        }
        List<Integer> odd = new ArrayList<>();
        for (var entry : mp.entrySet()) {
            if (entry.getValue().size() % 2 != 0) {
                odd.add(entry.getKey());
            }
        }
        int m = odd.size();
        if (m == 0) {
            return true;
        } else if (m == 2) {
            int a = odd.get(0), b = odd.get(1);
            if (!mp.get(b).contains(a) && !mp.get(a).contains(b)) {
                return true;
            }
            for (int i = 1; i <= n; i++) {
                Set<Integer> s = mp.getOrDefault(i, new HashSet<>());
                if (!s.contains(a) && !s.contains(b)) {
                    return true;
                }
            }
        } else if (m == 4) {
            int a = odd.get(0), b = odd.get(1), c = odd.get(2), d = odd.get(3);
            if (!mp.get(b).contains(a) && !mp.get(a).contains(b) && !mp.get(c).contains(d) && !mp.get(d).contains(c)) {
                return true;
            }
            if (!mp.get(c).contains(a) && !mp.get(a).contains(c) && !mp.get(b).contains(d) && !mp.get(d).contains(b)) {
                return true;
            }
            if (!mp.get(d).contains(a) && !mp.get(a).contains(d) && !mp.get(b).contains(c) && !mp.get(c).contains(b)) {
                return true;
            }
        }
        return false;
    }
}