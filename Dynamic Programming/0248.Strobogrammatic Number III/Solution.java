class Solution {
    public int strobogrammaticInRange(String low, String high) {
        int m = low.length(), n = high.length();
        List<String>[] dp = new List[n + 2];
        dp[1] = Arrays.asList(new String[]{"0", "1", "8"});
        dp[2] = Arrays.asList(new String[]{"11", "69", "88", "96", "00"});
        int idx = 2;
        while (++idx <= n) {
            List<String> tmp = new ArrayList<>();
            for (String s : dp[idx - 2]) {
                tmp.add("0" + s + "0");
                tmp.add("1" + s + "1");
                tmp.add("6" + s + "9");
                tmp.add("8" + s + "8");
                tmp.add("9" + s + "6");
            }
            dp[idx] = tmp;
        }
        int ans = 0;
        long lowNum = Long.parseLong(low), highNum = Long.parseLong(high);
        while (m <= n) {
            for (String s : dp[m]) {
                if (s.length() > 1 && s.charAt(0) == '0') {
                    continue;
                }
                long num = Long.parseLong(s);
                if (lowNum <= num && highNum >= num) {
                    ans++;
                }
            }
            m++;
        }
        return ans;
    }
}