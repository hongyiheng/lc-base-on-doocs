class Solution {
    public boolean checkValidString(String s) {
        char[] cs = s.toCharArray();
        int min = 0, max = 0;
        for (char c : cs) {
            if (c == '(') {
                min++;
                max++;
            } else if (c == ')') {
                min--;
                max--;
            } else {
                min--;
                max++;
            }
            min = Math.max(0, min);
            if (min > max) {
                return false;
            }
        }
        return min == 0;
    }
}