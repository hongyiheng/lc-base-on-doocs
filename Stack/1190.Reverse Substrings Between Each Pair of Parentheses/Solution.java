class Solution {
    public String reverseParentheses(String s) {
        Deque<Character> q = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == ')') {
                Deque<Character> tmp = new ArrayDeque();
                char v = q.pollLast();
                while (v != '(') {
                    tmp.addLast(v);
                    v = q.pollLast();
                }
                q.addAll(tmp);
            } else {
                q.addLast(c);
            }
        }
        StringBuilder ans = new StringBuilder();
        for (char c : q) {
            ans.append(c);
        }
        return ans.toString();
    }
}