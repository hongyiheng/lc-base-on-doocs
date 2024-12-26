class Solution {
    public boolean isSubstringPresent(String s) {
        Set<Integer> cs = new HashSet<>();
        int n = s.length();
        for (int i = 1; i < n; i++) {
            int v = (s.charAt(i - 1) - 'a') * 26 + s.charAt(i) - 'a';
            cs.add(v);
        }
        for (int i = n - 2; i > -1; i--) {
            int v = (s.charAt(i + 1) - 'a') * 26 + s.charAt(i) - 'a';
            if (cs.contains(v)) {
                return true;
            }
        }
        return false;
    }
}