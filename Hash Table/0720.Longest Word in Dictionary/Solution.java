class Solution {
    public String longestWord(String[] words) {
        String ans = "";
        Set<String> set = new HashSet<>(Arrays.asList(words));
        for (String s : set) {
            int n = s.length(), m = ans.length();
            if (n < m) {
                continue;
            }
            if (n == m && s.compareTo(ans) > 0) {
                continue;
            }
            boolean flag = true;
            for (int i = 1; i <= n; i++) {
                String sub = s.substring(0, i);
                if (!set.contains(sub)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans = s;
            }
        }
        return ans;
    }
}