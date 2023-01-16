class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        if (sentence1.length() < sentence2.length()) {
            return areSentencesSimilar(sentence2, sentence1);
        }
        if (sentence1.equals(sentence2)) {
            return true;
        }
        if (sentence1.startsWith(sentence2 + " ")) {
            return true;
        }
        if (sentence1.endsWith(" " + sentence2)) {
            return true;
        }
        for (int i = 0; i < sentence2.length(); i++) {
            if (sentence2.charAt(i) != ' ') {
                continue;
            }
            if (sentence1.startsWith(sentence2.substring(0, i) + " ") && sentence1.endsWith(sentence2.substring(i))) {
                return true;
            }
        }
        return false;
    }
}
