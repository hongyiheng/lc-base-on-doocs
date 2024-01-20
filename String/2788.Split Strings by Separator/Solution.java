class Solution {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> ans = new ArrayList<>();
        for (String w : words) {
            StringBuilder sb = new StringBuilder();
            for (char c : w.toCharArray()) {
                if (c == separator) {
                    if (sb.length() > 0) {
                        ans.add(sb.toString());
                        sb = new StringBuilder();
                    }
                } else {
                    sb.append(c);
                }
            }
            if (sb.length() > 0) {
                ans.add(sb.toString());
            }
        }
        return ans;
    }
}