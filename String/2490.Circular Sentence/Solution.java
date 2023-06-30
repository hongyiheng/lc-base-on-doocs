class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] ss = sentence.split(" ");
        int n = ss.length;
        char last = ss[n - 1].charAt(ss[n - 1].length() - 1);
        for (String s : ss) {
            if (last != s.charAt(0)) {
                return false;
            }
            last = s.charAt(s.length() - 1);
        }
        return true;
    }
}