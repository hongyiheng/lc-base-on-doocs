class Solution {
    public boolean doesAliceWin(String s) {
        Set<Character> d = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (d.contains(c)) {
                cnt++;
            }
        }
        return cnt != 0;
    }
}