class Solution {
    public int secondsToRemoveOccurrences(String s) {
        char[] cs = s.toCharArray();
        int n = s.length(), ans = 0;
        while (s.indexOf("01") != -1) {
            ans++;
            int i = 0;
            while (i < n - 1) {
                if (cs[i] == '0' && cs[i + 1] == '1') {
                    cs[i] = '1';
                    cs[i + 1] = '0';
                    i += 2;
                } else {
                    i++;
                }
            }
            s = new String(cs);
        }
        return ans;
    }
}