class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        List<String> ans = new ArrayList<>();
        String sec = "", fst = "";
        String[] words = text.split(" ");
        for (String word : words) {
            if (second.equals(sec) && first.equals(fst)) {
                ans.add(word);
            }
            fst = sec;
            sec = word;
        }
        String[] res = new String[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }
}