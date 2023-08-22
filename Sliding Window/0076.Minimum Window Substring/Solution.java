class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> cnt = new HashMap<>();
        for (char c : t.toCharArray()) {
            cnt.put(c, cnt.getOrDefault(c, 0) + 1);
        }
        int n = s.length(), k = cnt.size();
        int l = 0, r = 0;
        String ans = "";
        while (r < n) {
            if (cnt.containsKey(s.charAt(r))) {
                int v = cnt.get(s.charAt(r));
                cnt.put(s.charAt(r), --v);
                if (v == 0) {
                    k--;
                }
            }
            while (k == 0) {
                if (ans.equals("") || r - l + 1 < ans.length()) {
                    ans = s.substring(l, r + 1);
                }
                if (cnt.containsKey(s.charAt(l))) {
                    int v = cnt.get(s.charAt(l));
                    cnt.put(s.charAt(l), ++v);
                    if (v == 1) {
                        k++;
                    }
                }
                l++;
            }
            r++;
        }
        return ans;
    }
}