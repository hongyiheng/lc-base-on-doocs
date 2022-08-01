class Solution {
    public String generateTheString(int n) {
        char[] cs = new char[n];
        Arrays.fill(cs, 'a');
        if (n % 2 != 0) {
            return new String(cs);
        }
        cs[n - 1] = 'b';
        return new String(cs);
    }
}