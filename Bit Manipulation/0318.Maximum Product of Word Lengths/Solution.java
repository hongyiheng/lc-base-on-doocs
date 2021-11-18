class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] sim = new int[n];
        int index = 0;
        for (String w : words) {
            int t = 0;
            char[] chars = w.toCharArray();
            for (char c : chars) {
                int u = c - 'a';
                t |= (1 << u);
            }
            sim[index++] = t;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if ((sim[i] & sim[j]) == 0) {
                    ans = Math.max(words[i].length() * words[j].length(), ans);
                }
            }
        }
        return ans;
    }
}