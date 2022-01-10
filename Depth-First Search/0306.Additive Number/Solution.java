class Solution {
    String s;
    int n;
    public boolean isAdditiveNumber(String num) {
        s = num;
        n = num.length();
        return dfs(0, 0, 0, 0);
    }

    public boolean dfs(int index, long sum, long pre, int count) {
        if (index == n) {
            return count >= 3;
        }
        long cur = 0;
        for (int i = index; i < n; i++) {
            if ((index == 0 || index == 1) && i >= 19) {
                break;
            }
            if (i > index && s.charAt(index) == '0') {
                break;
            }
            cur = cur * 10 + s.charAt(i) - '0';
            if (count >= 2) {
                if (cur < sum) {
                    continue;
                } else if (cur > sum) {
                    break;
                }
            }
            if (dfs(i + 1, pre + cur, cur, count + 1)) {
                return true;
            }
        }
        return false;
    }
}