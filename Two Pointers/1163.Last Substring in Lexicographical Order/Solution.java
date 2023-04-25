class Solution {
    public String lastSubstring(String s) {
        int i = 0, j = 1, k = 0;
        while (j + k < s.length()) {
           if (s.charAt(i + k) == s.charAt(j + k)) {
               k++;
           } else if (s.charAt(i + k) < s.charAt(j + k)) {
               i += k + 1;
               if (i >= j) {
                   j = i + 1;
               }
               k = 0;
           } else {
               j += k + 1;
               k = 0;
           }
        }
        return s.substring(i);
    }
}
