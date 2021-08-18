class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] res = new int[26];
        for (int i = 0; i < sentence.length(); i++) {
            res[sentence.charAt(i) - 'a']++;
        }
        for (int num : res) {
            if (num <= 0) {
                return false;
            }
        }
        return true;
    }
}