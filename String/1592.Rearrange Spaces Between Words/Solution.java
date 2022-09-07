class Solution {
    public String reorderSpaces(String text) {
        int n = text.length();
        int idx = 0, cnt = 0;
        List<String> ws = new ArrayList<>();
        while (idx < n) {
            if (text.charAt(idx) == ' ') {
                cnt++;
                idx++;
                continue;
            }
            int s = idx;
            while (idx < n && text.charAt(idx) != ' ') {
                idx++;
            }
            ws.add(text.substring(s, idx));
        }
        if (cnt == 0) {
            return text;
        }
        String ans = "";
        if (ws.size() == 1) {
            ans = ws.get(0);
        } else {
            String s = "";
            for (int i = 0; i < cnt / (ws.size() - 1); i++) {
                s += " ";
            }
            ans = String.join(s, ws);
            cnt = cnt % (ws.size() - 1);
        }
        while (cnt-- > 0) {
            ans += " ";
        }
        return ans;
    }
}