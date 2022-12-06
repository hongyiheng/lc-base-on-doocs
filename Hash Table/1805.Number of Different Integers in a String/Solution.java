class Solution {
    public int numDifferentIntegers(String word) {
        int ans = 0;
        StringBuilder cur = new StringBuilder();
        Set<String> set = new HashSet<>();
        word += "a";
        for (int i = 0; i < word.length(); i++) {
            if (Character.isDigit(word.charAt(i))) {
                if (cur.length() == 1 && "0".equals(cur.toString())) {
                    cur = new StringBuilder();
                }
                cur.append(word.charAt(i));
            } else {
                if (cur.length() > 0) {
                    if (!set.contains(cur.toString())) {
                        ans++;
                        set.add(cur.toString());
                    }
                    cur = new StringBuilder();
                }
            }
        }
        return ans;
    }
}
