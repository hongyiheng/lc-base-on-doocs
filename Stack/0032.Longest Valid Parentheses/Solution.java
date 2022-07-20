class Solution {
    public int longestValidParentheses(String s) {
        Deque<int[]> q = new ArrayDeque<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int cur = chars[i] == '(' ? 0 : 1;
            if (q.isEmpty()) {
                q.addLast(new int[]{cur, i});
            } else {
                if (cur == 1 && q.peekLast()[0] == 0) {
                    q.pollLast();
                } else {
                    q.addLast(new int[]{cur, i});
                }
            }
        }
        int[] nums = new int[s.length()];
        while (!q.isEmpty()) {
            nums[q.poll()[1]] = 1;
        }
        int ans = 0, cur = 0;
        for (int i = 0; i < s.length(); i++) {
            if (nums[i] == 1) {
                ans = Math.max(ans, cur);
                cur = 0;
            } else {
                cur++;
            }
        }
        ans = Math.max(ans, cur);
        return ans;
    }
}