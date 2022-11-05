class Solution {
    public boolean parseBoolExpr(String expression) {
        Set<Character> cs = new HashSet<>();
        for (char c : new char[]{'t', 'f', '!', '&', '|'}) {
            cs.add(c);
        }
        Deque<Character> q = new ArrayDeque<>();
        for (char c : expression.toCharArray()) {
            if (cs.contains(c)) {
                q.addLast(c);
            }
            int t = 0, f = 0;
            if (c == ')') {
                while (q.peekLast() == 't' || q.peekLast() == 'f') {
                    if (q.peekLast() == 't') {
                        t++;
                    } else {
                        f++;
                    }
                    q.pollLast();
                }
                c = q.pollLast();
                char v = 'f';
                if ((c == '!' && f > 0) || (c == '&' && f == 0) || (c == '|' && t > 0)) {
                    v = 't';
                }
                q.addLast(v);
            }
        }

        return q.pollLast() == 't' ? true : false;
    }
}
