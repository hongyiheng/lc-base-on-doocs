class Solution {
    public int minAddToMakeValid(String s) {
        Deque<Character> q = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == ')') {
                if (!q.isEmpty() && q.peekLast() == '(') {
                    q.pollLast();
                    continue;
                }
            }
            q.addLast(c);
        }
        return q.size();
    }
}
