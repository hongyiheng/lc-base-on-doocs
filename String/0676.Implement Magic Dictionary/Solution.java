class MagicDictionary {

    String[] ws;

    public MagicDictionary() {
    }

    public void buildDict(String[] dictionary) {
        ws = dictionary;
    }

    public boolean search(String searchWord) {
        for (String s : ws) {
            if (searchWord.length() != s.length()) {
                continue;
            }
            int diff = 0;
            for (int i = 0; i < s.length() && diff <= 1; i++) {
                if (s.charAt(i) != searchWord.charAt(i)) {
                    diff++;
                }
            }
            if (diff == 1) {
                return true;
            }
        }
        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */