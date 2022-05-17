class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] mp = new int[26];
        for (int i = 0; i < 26; i++) {
            mp[order.charAt(i) - 'a'] = i;
        }
        String pre = "";
        for (String w : words) {
            boolean eq = true;
            for (int i = 0; i < Math.min(pre.length(), w.length()); i++) {
                int idx1 = pre.charAt(i) - 'a', idx2 = w.charAt(i) - 'a';
                if (mp[idx1] > mp[idx2]) {
                    return false;
                } else if (mp[idx1] < mp[idx2]) {
                    eq = false;
                    break;
                }
            }
            if (eq && pre.length() > w.length()) {
                return false;
            }
            pre = w;
        }
        return true;
    }
}