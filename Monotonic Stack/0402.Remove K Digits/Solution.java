class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> stk = new ArrayDeque<>();
        for (char c : num.toCharArray()) {
            while (k > 0 && !stk.isEmpty() && stk.peekLast() > c) {
                stk.pollLast();
                k--;
            }
            stk.addLast(c);
        }
        StringBuilder ans = new StringBuilder();
        while (!stk.isEmpty() && stk.size() > k) {
            char c = stk.pollFirst();
            if (ans.length() == 0 && c == '0') {
                continue;
            }
            ans.append(c);
        }
        return ans.length() == 0 ? "0" : ans.toString();
    }
}