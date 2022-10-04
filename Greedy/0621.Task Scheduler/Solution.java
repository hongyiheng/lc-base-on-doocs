class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> mp = new HashMap<>();
        for (char t : tasks) {
            mp.put(t, mp.getOrDefault(t, 0) + 1);
        }
        List<Integer> q = new ArrayList<>();
        for (Character k : mp.keySet()) {
            q.add(mp.get(k));
        }
        q.sort(Comparator.comparingInt(o -> -o));
        int cnt = 0, mx = q.get(0);
        for (int v : q) {
            if (v == mx) {
                cnt++;
            } else {
                break;
            }
        }
        int ans = (mx - 1) * (n + 1) + cnt;
        return Math.max(ans, tasks.length);
    }
}
