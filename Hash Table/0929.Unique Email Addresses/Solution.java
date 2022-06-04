class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> ans = new HashSet<>();
        for (String w : emails) {
            String[] ws = w.split("@");
            String pre = ws[0], tail = ws[1];
            StringBuilder newPre = new StringBuilder();
            for (char c : pre.toCharArray()) {
                if (c == '+') {
                    break;
                }
                if (c == '.') {
                    continue;
                } else {
                    newPre.append(c);
                }
            }
            newPre.append("@");
            ans.add(newPre.toString() + tail);
        }
        return ans.size();
    }
}