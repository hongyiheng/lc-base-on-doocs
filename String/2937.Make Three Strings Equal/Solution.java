class Solution {
    public int findMinimumOperations(String s1, String s2, String s3) {
        int n1 = s1.length(), n2 = s2.length(), n3 = s3.length();
        int n = Math.min(Math.min(n1, n2), n3);
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i) || s2.charAt(i) != s3.charAt(i)) {
                if (i == 0) {
                    return -1;
                }
                return n1 + n2 + n3 - 3 * i;
            }
        }
        return n1 + n2 + n3 - 3 * n;
    }
}