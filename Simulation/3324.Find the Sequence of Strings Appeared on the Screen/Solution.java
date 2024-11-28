class Solution {
    public List<String> stringSequence(String target) {
        List<String> ans = new ArrayList<>();
        String s = "";
        for (char t : target.toCharArray()) {
            char v = 'a';
            ans.add(s + v);
            while (v != t) {
                v++;
                ans.add(s + v);
            }
            s += v;
        }
        return ans;
    }
}