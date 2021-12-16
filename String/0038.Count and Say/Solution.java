class Solution {
    public String countAndSay(int n) {
        String ans = "1";
        for (int i = 0; i < n - 1; i++) {
            ans = dfs(ans);
        }
        return ans;
    }

    public String dfs(String n) {
        StringBuffer ans = new StringBuffer();
        char[] chars = n.toCharArray();
        int cur = chars[0] - '0';
        int count = 1;
        for (int i = 1; i < chars.length; i++) {
            int num = chars[i] - '0';
            if (cur != num) {
                ans.append(count);
                ans.append(cur);
                cur = num;
                count = 1;
            } else {
                count++;
            }
        }
        ans.append(count);
        ans.append(cur);
        return ans.toString();
    }
}