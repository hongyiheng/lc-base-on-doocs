class Solution {
    public String removeStars(String s) {
        Deque<String> q = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '*') {
                q.pollLast();
            } else {
                q.addLast(String.valueOf(c));
            }
        }
        return String.join("", q);
    }
}
