class Solution {
    public String makeLargestSpecial(String s) {
        int n = s.length();
        if (n <= 2) {
            return s;
        }
        int cnt = 0, last = 0;
        List<String> q = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            cnt += s.charAt(i) == '1' ? 1 : -1;
            if (cnt == 0) {
                q.add('1' + makeLargestSpecial(s.substring(last + 1, i)) + '0');
                last = i + 1;
            }
        }
        q.sort((a, b) -> b.compareTo(a));
        return String.join("", q);
    }
}
