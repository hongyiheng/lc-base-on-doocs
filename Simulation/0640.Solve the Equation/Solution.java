class Solution {
    public String solveEquation(String equation) {
        char[] cs = equation.toCharArray();
        int idx = 0, n = cs.length;
        int leftX = 0, rightX = 0, left = 0, right = 0;
        String cur = "";
        boolean leftPart = true;
        while (idx < n) {
            if ('0' <= cs[idx] && cs[idx] <= '9') {
                cur += cs[idx];
            } else if (cs[idx] == 'x') {
                if ("-".equals(cur)) {
                    cur = "-1";
                }
                if (leftPart) {
                    leftX += "".equals(cur) ? 1 : Integer.parseInt(cur);
                } else {
                    rightX += "".equals(cur) ? 1 : Integer.parseInt(cur);
                }
                cur = "";
            } else {
                if (leftPart) {
                    left += "".equals(cur) ? 0 : Integer.parseInt(cur);
                } else {
                    right += "".equals(cur) ? 0 : Integer.parseInt(cur);
                }
                cur = "";
                if (cs[idx] == '=') {
                    leftPart = false;
                }
                if (cs[idx] == '-') {
                    cur = "-";
                }
            }
            idx++;
        }
        if (!"".equals(cur)) {
            right += Integer.parseInt(cur);
        }
        if (leftX == rightX && left == right) {
            return "Infinite solutions";
        }
        if (leftPart || leftX == rightX) {
            return "No solution";
        }
        return "x=" + (right - left) / (leftX - rightX);
    }
}