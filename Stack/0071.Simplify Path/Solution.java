class Solution {
    public String simplifyPath(String path) {
        Deque<String> stk = new ArrayDeque<>();
        String[] paths = path.split("/");
        for (String item : paths) {
            if ("".equals(item) || "/".equals(item) || ".".equals(item)) {
                continue;
            }
            if ("..".equals(item)) {
                stk.pollLast();
                continue;
            }
            stk.addLast(item);
        }
        String ans = String.join("/", stk);
        return "/" + ans;
    }
}