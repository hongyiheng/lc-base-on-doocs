class Solution {
    public String convertDateToBinary(String date) {
        String[] ans = new String[3];
        for (int i = 0; i < 3; i++) {
            String s = "";
            int t = 0, v = Integer.valueOf(date.split("-")[i]);
            for (int j = 0; j < 13 && t != v; j++) {
                if ((v >> j & 1) != 0) {
                    s = "1" + s;
                    t += 1 << j;
                } else {
                    s = "0" + s;
                }
            }
            ans[i] = s;
        }
        return String.join("-", ans);
    }
}