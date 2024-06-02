class Solution {
    public String compressedString(String word) {
        StringBuilder ans = new StringBuilder();
        int cnt = 0, cur = -1;
        for (char c : word.toCharArray()) {
            if (cnt >= 9) {
                ans.append(String.valueOf(cnt));
                ans.append((char)(cur + 'a'));
                cnt -= 9;
            }
            if (cur != c - 'a') {
                if (cnt > 0) {
                    ans.append(String.valueOf(cnt));
                    ans.append((char)(cur + 'a'));
                }
                cur = c - 'a';
                cnt = 1;
            } else {
                cnt++;
            }
        }
        ans.append(String.valueOf(cnt));
        ans.append((char)(cur + 'a'));
        return ans.toString();
    }
}