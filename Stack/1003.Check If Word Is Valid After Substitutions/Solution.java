class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        if (n % 3 != 0) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(c);
            if (sb.length() >= 3 && sb.substring(sb.length() - 3, sb.length()).equals("abc")) {
                for (int i = 0; i < 3; i++) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
        return sb.length() == 0;
    }
}