class Solution {
    public boolean isValid(String word) {
        if (word.length() < 3) {
            return false;
        }
        Set<Character> vs = new HashSet<>(Arrays.asList('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'));
        boolean v = false, c = false;
        for (char x : word.toCharArray()) {
            if ('0' <= x && x <= '9') {
                continue;
            } else if (vs.contains(x)) {
                v = true;
            } else if (('a' <= x && x <= 'z') || ('A' <= x && x <= 'Z')) {
                c = true;
            } else {
                return false;
            }
        }
        return v && c;
    }
}