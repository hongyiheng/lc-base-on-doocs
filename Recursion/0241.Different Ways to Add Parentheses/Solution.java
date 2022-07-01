class Solution {
    char[] chars;
    String s;

    public List<Integer> diffWaysToCompute(String expression) {
        s = expression;
        chars = s.toCharArray();
        return dfs(0, chars.length - 1);
    }

    public List<Integer> dfs(int l, int r) {
        List<Integer> ans = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                continue;
            }
            List<Integer> left = dfs(l, i - 1), right = dfs(i + 1, r);
            for (int a : left) {
                for (int b : right) {
                    int cur = 0;
                    if (chars[i] == '+') {
                        cur = a + b;
                    } else if (chars[i] == '-') {
                        cur = a - b;
                    } else {
                        cur = a * b;
                    }
                    ans.add(cur);
                }
            }
        }
        if (ans.isEmpty()) {
            ans.add(Integer.parseInt(s.substring(l, r + 1)));
        }
        return ans;
    }
}