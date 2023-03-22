class Solution {
    public int maxDiff(int num) {
        String s = String.valueOf(num);
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != '9') {
                s = s.replace(s.charAt(i), '9');
                break;
            }
        }
        int mx = Integer.parseInt(s);
        s = String.valueOf(num);
        for (int i = 0; i < n; i++) {
            if (i == 0 && s.charAt(i) != '1') {
                s = s.replace(s.charAt(i), '1');
                break;
            }
            if (i != 0 && s.charAt(i) != '0' && s.charAt(i) != s.charAt(0)) {
                s = s.replace(s.charAt(i), '0');
                break;
            }
        }
        return mx - Integer.parseInt(s);
    }
}