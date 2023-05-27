class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int m = words.length, n = words[0].length();
        List<Integer> ans = new ArrayList<>();
        if (m * n > s.length()) {
            return ans;
        }
        Map<String, Integer> t = new HashMap<>();
        for (String w : words) {
            t.put(w, t.getOrDefault(w, 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            int l = i, r = i, cnt = 0;
            Map<String, Integer> cur = new HashMap<>();
            while (r + n <= s.length()) {
                String w = s.substring(r, r + n);
                r += n;
                if (!t.containsKey(w)) {
                    l = r;
                    cnt = 0;
                    cur.clear();
                    continue;
                }
                cur.put(w, cur.getOrDefault(w, 0) + 1);
                cnt++;
                while (cur.get(w) > t.get(w)) {
                    String w2 = s.substring(l, l + n);
                    l += n;
                    cur.put(w2, cur.get(w2) - 1);
                    cnt--;
                }
                if (cnt == m) {
                    ans.add(l);
                }
            }
        }
        return ans;
    }
}
