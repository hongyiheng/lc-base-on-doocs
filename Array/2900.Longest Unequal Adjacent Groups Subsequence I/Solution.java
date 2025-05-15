class Solution {

    public List<String> f(String[] words, int[] groups, int t) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (groups[i] == t) {
                ans.add(words[i]);
                t ^= 1;
            }
        }
        return ans;
    }

    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> ans1 = f(words, groups, 0), ans2 = f(words, groups, 1);
        return ans1.size() > ans2.size() ? ans1 : ans2;
    }
}