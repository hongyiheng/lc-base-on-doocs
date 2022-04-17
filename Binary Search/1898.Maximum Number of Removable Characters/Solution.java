class Solution {
    String s;
    String p;
    int[] removable;
    public int maximumRemovals(String s, String p, int[] removable) {
        this.s = s;
        this.p = p;
        this.removable = removable;
        int left = 0, right = removable.length;
        while (left < right) {
            int mid = (left + right + 1) >> 1;
            if (check(mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public boolean check(int x) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < x; i++) {
            set.add(removable[i]);
        }
        char[] sChars = s.toCharArray();
        char[] pChars = p.toCharArray();
        int idx = 0;
        for (int i = 0; i < sChars.length; i++) {
            if (idx == pChars.length) {
                break;
            }
            if (set.contains(i)) {
                continue;
            }
            if (sChars[i] == pChars[idx]) {
                idx++;
            }
        }
        return idx == pChars.length;
    }
}