class Solution {

    Map<String, List<String>> mp = new HashMap<>();
    Map<String, Boolean> f = new HashMap<>();

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        for (String s : allowed) {
            String key = s.substring(0, 2);
            mp.computeIfAbsent(key, k -> new ArrayList<>()).add(s.substring(2));
        }
        return dfs(bottom, "");
    }

    public boolean dfs(String row, String cur) {
        if (f.containsKey(row + cur)) {
            return f.get(row + cur);
        }
        if (row.length() == 1) {
            return true;
        }
        if (cur.length() + 1 == row.length()) {
            return dfs(cur, "");
        }
        for (String c : mp.getOrDefault(row.substring(cur.length(), cur.length() + 2), new ArrayList<>())) {
            if (dfs(row, cur + c)) {
                return true;
            }
        }
        f.put(row + cur, false);
        return false;
    }
}
