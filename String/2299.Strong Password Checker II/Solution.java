class Solution {
    public boolean strongPasswordCheckerII(String password) {
        int n = password.length();
        if (n < 8) {
            return false;
        }
        boolean sm = false, bi = false, num = false, sp = false;
        char last = ' ';
        for (char c : password.toCharArray()) {
            if (c == last) {
                return false;
            }
            if (c >= 'a' && c <= 'z') {
                sm = true;
            }
            if (c >= 'A' && c <= 'Z') {
                bi = true;
            }
            if (c >= '0' && c <= '9') {
                num = true;
            }
            if ("!@#$%^&*()-+".indexOf(c) != -1) {
                sp = true;
            }
            last = c;
        }
        return sm && bi && num && sp;
    }
}