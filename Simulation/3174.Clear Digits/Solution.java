class Solution {
    public String clearDigits(String s) {
        StringBuilder ans = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                if (ans.length() > 0) {
                    ans.deleteCharAt(ans.length() - 1);
                }
            } else {
                ans.append(c);
            }
        }
        return ans.toString();
    }
}