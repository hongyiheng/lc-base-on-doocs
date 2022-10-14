class Solution {
    char[] s = new char[]{'c', 'r', 'o', 'a', 'k'};
    Map<Character, Integer> cnt = new HashMap<>();

    public int minNumberOfFrogs(String croakOfFrogs) {
        for (char c : s) {
            cnt.put(c, 0);
        }
        int ans = 0;
        for (char c : croakOfFrogs.toCharArray()) {
            cnt.put(c, cnt.get(c) + 1);
            int cur = getCur();
            if (cur == -1) {
                return -1;
            }
            ans = Math.max(ans, cur);
        }
        return cnt.get('c').equals(cnt.get('k')) ? ans : -1;
    }

    public int getCur() {
        int cur = Integer.MAX_VALUE;
        for (char c : s) {
            if (cnt.get(c) <= cur) {
                cur = cnt.get(c);
            } else {
                return -1;
            }
        }
        return cnt.get('c') - cnt.get('k');
    }
}
