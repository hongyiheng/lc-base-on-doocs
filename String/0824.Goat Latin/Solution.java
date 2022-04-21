class Solution {
    public String toGoatLatin(String sentence) {
        String[] words = sentence.split(" ");
        int idx = 0;
        for (String w : words) {
            char c = Character.toLowerCase(w.charAt(0));
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                words[idx] = w + "ma";
            } else {
                words[idx] = w.substring(1) + w.charAt(0) + "ma";
            }
            for (int i = 0; i <= idx; i++) {
                words[idx] += "a";
            }
            idx++;
        }
        return String.join(" ", words);
    }
}