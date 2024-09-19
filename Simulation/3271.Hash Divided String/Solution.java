class Solution {
    public String stringHash(String s, int k) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i += k) {
            int v = 0;
            for (int j = i; j < i + k; j++) {
                v += s.charAt(j) - 'a';
            }
            ans.append((char)(v % 26 + 'a'));
        }
        return ans.toString();
    }
}