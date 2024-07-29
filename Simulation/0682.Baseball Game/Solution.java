class Solution {
    public int calPoints(String[] operations) {
        Deque<Integer> ans = new ArrayDeque<>();
        for (int i = 0; i < operations.length; i++) {
            String c = operations[i];
            if ("+".equals(c)) {
                int a = ans.pollLast();
                int b = ans.peekLast();
                ans.add(a);
                ans.add(a + b);
            } else if ("D".equals(c)) {
                ans.add(ans.peekLast() * 2);
            } else if ("C".equals(c)) {
                ans.pollLast();
            } else {
                ans.add(Integer.parseInt(c));
            }
        }
        int t = 0;
        for (int v : ans) {
            t += v;
        }
        return t;
    }
}