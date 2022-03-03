class Solution {
    public List<String> findStrobogrammatic(int n) {
        List<String>[] dp = new List[n + 2];
        dp[1] = Arrays.asList(new String[]{"8", "1", "0"});
        dp[2] = Arrays.asList(new String[]{"11","69","88","96", "00"});
        int idx = 2;
        while (idx++ < n) {
            List<String> tmp = new ArrayList<>();
            for (String s : dp[idx - 2]) {
                tmp.add("6" + s + "9");
                tmp.add("9" + s + "6");
                tmp.add("8" + s + "8");
                tmp.add("1" + s + "1");
                tmp.add("0" + s + "0");
            }
            dp[idx] = tmp;
        }
        dp[2] = Arrays.asList(new String[]{"11","69","88","96"});
        if (n > 2) {
            List<String> tmp = new ArrayList<>();
            for (String s : dp[n]) {
                if (s.charAt(0) != '0') {
                    tmp.add(s);
                }
            }
            dp[n] = tmp;
        }
        return dp[n];
    }
}