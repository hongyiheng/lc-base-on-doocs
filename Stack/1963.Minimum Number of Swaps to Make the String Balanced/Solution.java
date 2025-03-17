class Solution {
    public int minSwaps(String s) {
        Deque<Character> q = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == ']' && !q.isEmpty() && q.peekLast() == '[') {
                q.pollLast();
            } else {
                q.addLast(c);
            }
        }
        return (q.size() / 2 + 1) / 2;
    }
}