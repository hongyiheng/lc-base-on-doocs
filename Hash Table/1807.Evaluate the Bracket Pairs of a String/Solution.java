class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> mp = new HashMap<>();
        for (List<String> item : knowledge) {
            mp.put(item.get(0), item.get(1));
        }
        char[] chars = s.toCharArray();
        String ans = "", key = "";
        boolean flag = false;
        for (char c : chars) {
            if (c == '(') {
                flag = true;
                continue;
            } else if (c == ')') {
                flag = false;
                ans += mp.getOrDefault(key, "?");
                key = "";
                continue;
            }
            if (flag) {
                key += c;
            } else {
                ans += c;
            }
        }
        return ans;
    }
}