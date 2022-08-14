class Solution {
    public char repeatedCharacter(String s) {
        boolean[] cs = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if (cs[idx]) {
                return s.charAt(i);
            } else {
                cs[idx] = true;
            }
        }
        return s.charAt(0);
    }
}