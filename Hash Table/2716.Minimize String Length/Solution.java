class Solution {
    public int minimizedStringLength(String s) {
        Set<Character> cs = new HashSet<>();
        for (char c : s.toCharArray()) {
            cs.add(c);
        }
        return cs.size();
    }
}