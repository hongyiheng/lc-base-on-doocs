class Solution {
    public String greatestLetter(String s) {
        boolean[][] cs = new boolean[26][2];
        for (char c : s.toCharArray()) {
            if (c >= 'a') {
                cs[c - 'a'][0] = true;
            } else {
                cs[c - 'A'][1] = true;
            }
        }
        for (int i = 25; i > -1; i--) {
            if (cs[i][0] && cs[i][1]) {
                return String.valueOf((char)(i + 'A'));
            }
        }
        return "";
    }
}