class Solution {
    public List<String> generatePossibleNextMoves(String currentState) {
        List<String> ans = new ArrayList<>();
        char[] chars = currentState.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            if (chars[i - 1] == '+' && chars[i] == '+') {
                chars[i - 1] = '-';
                chars[i] = '-';
                ans.add(new String(chars));
                chars[i - 1] = '+';
                chars[i] = '+';
            }
        }
        return ans;
    }
}