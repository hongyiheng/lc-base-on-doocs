class Solution {
    public List<String> printVertically(String s) {
        String[] ss = s.split(" ");
        int m = ss.length, n = 0;
        for (int i = 0; i < m; i++) {
            n = Math.max(n, ss[i].length());
        }
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder col = new StringBuilder();
            for (int j = 0; j < m; j++) {
                char c = i < ss[j].length() ? ss[j].charAt(i) : ' ';
                col.append(c);
            }
            for (int k = col.length() - 1; k > -1; k--) {
                if (col.charAt(k) != ' ') {
                    ans.add(col.toString().substring(0, k + 1));
                    break;
                }
            }
        }
        return ans;
    }
}