class Solution {
    public boolean checkIfPangram(String sentence) {
        boolean[] cnt = new boolean[26];
        for (char c : sentence.toCharArray()) {
            cnt[c - 'a'] = true;
        }
        boolean ans = true;
        for (boolean v : cnt) {
            ans &= v;
        }
        return ans;
    }
}
