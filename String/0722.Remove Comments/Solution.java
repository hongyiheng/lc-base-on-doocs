class Solution {
    public List<String> removeComments(String[] source) {
        String s = String.join("#", source);
        int i = 0;
        while (i + 1 < s.length()) {
            if ("//".equals(s.substring(i, i + 2))) {
                int end = s.indexOf("#", i + 2);
                if (end != -1) {
                    s = s.substring(0, i) + s.substring(end);
                } else {
                    s = s.substring(0, i);
                }
            } else if ("/*".equals(s.substring(i, i + 2))) {
                int end = s.indexOf("*/", i + 2);
                if (end != -1) {
                    s = s.substring(0, i) + s.substring(end + 2);
                }
            } else {
                i++;
            }
        }
        List<String> ans = new ArrayList<>();
        for (String w : s.split("#")) {
            if (!w.isEmpty()) {
                ans.add(w);
            }
        }
        return ans;
    }
}