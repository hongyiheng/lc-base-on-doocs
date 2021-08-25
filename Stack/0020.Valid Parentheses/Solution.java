class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c: s.toCharArray()) {
            if (c == '(') {
                stack.addLast(')');
            } else if (c == '[') {
                stack.addLast(']');
            } else if (c == '{') {
                stack.addLast('}');
            } else if (stack.isEmpty() || c != stack.pollLast()) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}