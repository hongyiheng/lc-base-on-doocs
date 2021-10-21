class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] mp = new String[]{
            ".-","-...","-.-.","-..",".","..-.",
            "--.","....","..",".---","-.-",".-..",
            "--","-.","---",".--.","--.-",".-.",
            "...","-","..-","...-",".--","-..-",
            "-.--","--.."
        };
        Set<String> ans = new HashSet<>();
        for (String item : words) {
            String temp = "";
            for (int i = 0; i < item.length(); i++) {
                temp += mp[item.charAt(i) - 'a'];
            }
            ans.add(temp);
        }
        return ans.size();
    }
}