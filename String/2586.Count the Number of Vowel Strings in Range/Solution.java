class Solution {
    public int vowelStrings(String[] words, int left, int right) {
        Set<Character> s = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int ans = 0;
        for (int i = left; i <= right; i++) {
            int n = words[i].length();
            if (s.contains(words[i].charAt(0)) && s.contains(words[i].charAt(n - 1))) {
                ans++;
            }
        }
        return ans;
    }
}