class Solution {
    public int minMaxDifference(int num) {
        int mx = num;
        String s = String.valueOf(num);
        for (char c : s.toCharArray()) {
            if (c != '9') {
                mx = Integer.valueOf(String.valueOf(num).replace(c, '9'));
                break;
            }
        }
        return mx - Integer.valueOf(s.replace(s.charAt(0), '0'));
    }
}