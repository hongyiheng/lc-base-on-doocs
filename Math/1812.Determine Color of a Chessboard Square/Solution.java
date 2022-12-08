class Solution {
    public boolean squareIsWhite(String coordinates) {
        int r = coordinates.charAt(0) - 'a';
        int c = coordinates.charAt(1) - '1';
        return r % 2 == 0 ? c % 2 != 0 : c % 2 == 0;
    }
}
