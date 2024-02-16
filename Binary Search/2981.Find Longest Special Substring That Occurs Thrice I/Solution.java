class Solution {

    public boolean check(int x, Map<Integer, List<Integer>> cnt) {
        for (List<Integer> q : cnt.values()) {
            int k = 0;
            for (int v : q) {
                if (v < x) {
                    continue;
                }
                k += v - x + 1;
            }
            if (k >= 3) {
                return true;
            }
        }
        return false;
    }

    public int maximumLength(String s) {
        Map<Integer, List<Integer>> cnt = new HashMap<>();
        int lastVal = 0, lastLen = 0;
        for (char c : s.toCharArray()) {
            int v = c - 'a';
            if (v == lastVal) {
                lastLen++;
            } else {
                cnt.computeIfAbsent(lastVal, k -> new ArrayList<>()).add(lastLen);
                lastLen = 1;
            }
            lastVal = v;
        }
        cnt.computeIfAbsent(lastVal, k -> new ArrayList<>()).add(lastLen);

        int l = 0, r = s.length();
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (check(mid, cnt)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return r > 0 ? r : -1;
    }
}