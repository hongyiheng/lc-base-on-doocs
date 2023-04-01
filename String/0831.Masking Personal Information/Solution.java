class Solution {
    public String maskPII(String s) {
        if (s.contains("@")) {
            s = s.toLowerCase();
            int idx = s.indexOf('@');
            return s.charAt(0) + "*****" + s.substring(idx - 1);
        }
        s = s.replaceAll("[^0-9]", "");
        int n = s.length();
        if (n == 10) {
            return "***-***-" + s.substring(n - 4);
        }
        String country = "+";
        for (int i = 0; i < n - 10; i++) {
            country += "*";
        }
        return country + "-***-***-" + s.substring(n - 4);
    }
}