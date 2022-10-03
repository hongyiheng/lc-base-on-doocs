class Solution {
    public String smallestSubsequence(String s) {
        Map<Character, Integer> cnt = new HashMap<>();
        char[] cs = s.toCharArray();
        for (char c : cs) {
            cnt.put(c, cnt.getOrDefault(c, 0) + 1);
        }
        Deque<Character> q = new ArrayDeque<>();
        Set<Character> used = new HashSet<>();
        for (char c : cs) {
            if (!used.contains(c)) {
                while (!q.isEmpty() && q.peekLast() > c && cnt.get(q.peekLast()) > 0) {
                    used.remove(q.pollLast());
                }
                q.addLast(c);
                used.add(c);
            }
            cnt.put(c, cnt.get(c) - 1);
        }
        String ans = "";
        for (char c : q) {
            ans += String.valueOf(c);
        }
        return ans;
    }
}
