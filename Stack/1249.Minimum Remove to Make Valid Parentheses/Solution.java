class Solution {
    public String minRemoveToMakeValid(String s) {
        int l = 0, r = 0;
        for (char c : s.toCharArray()) {
            if (c == ')') {
                r++;
            }
        }
        List<Character> q = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (r - l <= 0) {
                    continue;
                }
                l++;
            } else if (c == ')') {
                r--;
                if (l == 0) {
                    continue;
                }
                l--;
            }
            q.add(c);
        }
        return q.stream().map(String::valueOf).collect(Collectors.joining());
    }
}