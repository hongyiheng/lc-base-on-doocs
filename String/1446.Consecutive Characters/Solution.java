class Solution {
    public int maxPower(String s) {
        int res = 1, curCount = 1;
        char[] chars = s.toCharArray();
        char cur = chars[0];
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == cur) {
                curCount++;
            } else {
                cur = chars[i];
                curCount = 1;
            }
            res = Math.max(res, curCount);
        }
        return res;
    }
}