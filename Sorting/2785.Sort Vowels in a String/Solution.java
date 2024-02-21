class Solution {
    public String sortVowels(String s) {
        Set<Character> vs = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        List<Character> vowels = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (vs.contains(c)) {
                vowels.add(c);
            }
        }
        Collections.sort(vowels);
        StringBuilder ans = new StringBuilder();
        int i = 0;
        for (char c : s.toCharArray()) {
            if (vs.contains(c)) {
                ans.append(vowels.get(i++));
            } else {
                ans.append(c);
            }
        }
        return ans.toString();
    }
}