class Solution {
    public String answerString(String word, int numFriends) {
        if (numFriends == 1) {
            return word;
        }
        int n = word.length();
        String ans = "";
        for (int i = 0 ; i < n ; i++) {
            String ns = word.substring(i, Math.min(n, i + n - (numFriends - 1)));
            if (ns.compareTo(ans) > 0) {
                ans = ns;
            }
        }
        return ans;
    }
}