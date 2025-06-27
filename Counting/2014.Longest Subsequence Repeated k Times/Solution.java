class Solution {

    private boolean check(String x, String s, int k) {
        int i = 0, cnt = 0;
        for (char c : s.toCharArray()) {
            if (c == x.charAt(i)) {
                i++;
            }
            if (i == x.length()) {
                cnt++;
                i = 0;
                if (cnt >= k) {
                    return true;
                }
            }
        }
        return false;
    }

    public String longestSubsequenceRepeatedK(String s, int k) {
        Map<Character, Integer> cnt = new HashMap<>();
        for (char c : s.toCharArray()) {
            cnt.put(c, cnt.getOrDefault(c, 0) + 1);
        }
        List<Character> cs = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            if (cnt.getOrDefault(c, 0) >= k) {
                cs.add(c);
            }
        }
        Deque<String> q = new ArrayDeque<>();
        q.add("");
        String ans = "";
        while (!q.isEmpty()) {
            String x = q.poll();
            for (char c : cs) {
                String nx = x + c;
                if (check(nx, s, k)) {
                    ans = nx;
                    q.add(nx);
                }
            }
        }
        return ans;
    }
}