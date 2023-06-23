class Solution {
    public int maximumValue(String[] strs) {
        int ans = 0;
        for (String s : strs) {
            boolean num = true;
            for (char c : s.toCharArray()) {
                if (!Character.isDigit(c)) {
                    num = false;
                    break;
                }
            }
            int v = num ? Integer.valueOf(s) : s.length();
            ans = Math.max(ans, v);
        }
        return ans;
    }
}