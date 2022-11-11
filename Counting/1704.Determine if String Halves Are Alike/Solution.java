class Solution {
    public boolean halvesAreAlike(String s) {
        Set<Character> ss = new HashSet<>();
        for (char c : new char[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'}) {
            ss.add(c);
        }
        int n = s.length(), ans = 0;
        int mid = n / 2;
        for (int i = 0; i < n; i++) {
            if (ss.contains(s.charAt(i))) {
                ans += i + 1 <= mid ? 1 : -1;
            }
        }
        return ans == 0;
    }
}
