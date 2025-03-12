class Solution {
    public int countOfSubstrings(String word, int k) {
        Set<Character> vowel = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int n = word.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            Set<Character> s = new HashSet<>();
            int t = 0;
            for (int j = i; j < n; j++) {
                char c = word.charAt(j);
                if (vowel.contains(c)) {
                    s.add(c);
                } else {
                    t++;
                }
                if (s.size() == 5 && t == k) {
                    ans++;
                }
                if (t > k) {
                    break;
                }
            }
        }
        return ans;
    }
}