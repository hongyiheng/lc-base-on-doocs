class Solution {
    public String strWithout3a3b(int a, int b) {
        String ans = "";
        while (a > 0 || b > 0) {
            if (a >= b) {
                if (ans.length() >= 2 && ans.substring(ans.length() - 2).equals("aa")) {
                    ans += "b";
                    b--;
                } else {
                    ans += "a";
                    a--;
                }
            } else {
                if (ans.length() >= 2 && ans.substring(ans.length() - 2).equals("bb")) {
                    ans += "a";
                    a--;
                } else {
                    ans += "b";
                    b--;
                }
            }
        }
        return ans;
    }
}