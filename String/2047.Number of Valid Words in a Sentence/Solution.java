class Solution {
    public int countValidWords(String sentence) {
        String[] words = sentence.split(" ");
        int ans = 0;
        for (String w : words) {
            if (check(w)) {
                ans++;
            }
        }
        return ans;
    }

    public boolean check(String w) {
        if (" ".equals(w) || w.length() == 0) {
            return false;
        }
        char[] chars = w.toCharArray();
        int linkIndex = -1;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ('a' <= c && 'z' >= c) {
                continue;
            } else if ('0' <= c && '9' >= c) {
                return false;
            } else if (c == '-') {
                if (linkIndex == -1) {
                    linkIndex = i;
                } else {
                    return false;
                }
            } else {
                if (i != chars.length - 1) {
                    return false;
                }
            }
        }
        if (linkIndex != -1) {
            int pre = linkIndex - 1;
            int next = linkIndex + 1;
            if (pre >= 0 && next < chars.length && chars[pre] >= 'a' && chars[pre] <= 'z' && chars[next] >= 'a' && chars[next] <= 'z') {
                return true;
            } else {
                return false;
            }
        }
        return true;
    }
}