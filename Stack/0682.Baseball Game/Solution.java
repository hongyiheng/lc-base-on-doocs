class Solution {
    public int calPoints(String[] ops) {
        Deque<Integer> stk = new ArrayDeque<>();
        for (String item: ops) {
            if (item.equals("C")) {
                stk.pollLast();
            } else if (item.equals("D")) {
                stk.addLast(stk.peekLast() * 2);
            } else if (item.equals("+")) {
                int first = stk.pollLast();
                int second = stk.peekLast();
                stk.addLast(first);
                stk.addLast(first + second);
            } else {
                stk.addLast(Integer.parseInt(item));
            }
        }
        int res = 0;
        while (!stk.isEmpty()) {
            res += stk.pollLast();
        }
        return res;
    }
}