class Solution {
    public int calPoints(String[] ops) {
        int ans = 0;
        Deque<Integer> stk = new ArrayDeque<>();
        for (String o : ops) {
            int num = 0;
            if ("+".equals(o)) {
                int last = stk.pollLast();
                num += last;
                num += stk.peekLast();
                stk.addLast(last);
            } else if ("D".equals(o)) {
                num = stk.peekLast() * 2;
            } else if ("C".equals(o)) {
                num = -stk.pollLast();
            } else {
                num = Integer.parseInt(o);
            }
            ans += num;
            if (!"C".equals(o)) {
                stk.addLast(num);
            }
        }
        return ans;
    }
}