class Solution {
    public boolean checkPalindromeFormation(String a, String b) {
        return check(a, b) || check(b, a);
    }

    public boolean check(String a, String b) {
        int l = 0, r = a.length() - 1;
        while (l < r && a.charAt(l) == b.charAt(r)) {
            l++;
            r--;
        }
        return l >= r || check2(a, l, r) || check2(b, l, r);
    }

    public boolean check2(String s, int l, int r) {
        return s.substring(l, r + 1).equals(new StringBuilder(s.substring(l, r + 1)).reverse().toString());
    }
}