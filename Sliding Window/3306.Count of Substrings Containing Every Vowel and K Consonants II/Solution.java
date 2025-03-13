class Solution {

    public long f(String word, int k) {
        Map<Character, Integer> vowel = new HashMap<>();
        long ans = 0;
        int l = 0, cnt = 0;
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        for (char c : word.toCharArray()) {
            if (vowels.contains(c)) {
                vowel.put(c, vowel.getOrDefault(c, 0) + 1);
            } else {
                cnt++;
            }
            while (vowel.keySet().size() == 5 && cnt >= k) {
                char t = word.charAt(l);
                if (vowels.contains(t)) {
                    vowel.put(t, vowel.get(t) - 1);
                    if (vowel.get(t) == 0) {
                        vowel.remove(t);
                    }
                } else {
                        cnt--;
                }
                l++;
            }
            ans += l;
        }
        return ans;
    }

    public long countOfSubstrings(String word, int k) {
        return f(word, k) - f(word, k + 1);
    }
}