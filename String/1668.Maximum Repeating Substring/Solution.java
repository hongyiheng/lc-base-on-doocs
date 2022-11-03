class Solution {
    public int maxRepeating(String sequence, String word) {
        String ori = word;
        int ans = 0;
        while (sequence.contains(word)) {
            word += ori;
            ans++;
        }
        return ans;
    }
}
