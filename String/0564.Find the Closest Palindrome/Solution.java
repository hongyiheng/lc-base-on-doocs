class Solution {
    public String nearestPalindromic(String n) {
        int m = n.length();
        long num = Long.parseLong(n);
        Set<Long> set = new HashSet();
        set.add((long) (Math.pow(10, m) + 1));
        set.add((long) (Math.pow(10, m - 1) - 1));
        long mid = Long.parseLong(n.substring(0, (m + 1) / 2));
        for (long i = mid - 1; i <= mid + 1; i++) {
            StringBuilder sb = new StringBuilder(String.valueOf(i));
            int len = m % 2 == 0 ? sb.length() - 1 : sb.length() - 2;
            while (len >= 0) {
                sb.append(sb.charAt(len--));
            }
            long tmp = Long.parseLong(sb.toString());
            if (tmp != num) {
                set.add(tmp);
            }
        }
        long ans = -1L;
        for (long v : set) {
            if (Math.abs(num - v) < Math.abs(num - ans)) {
                ans = v;
            }
            if (Math.abs(num - v) == Math.abs(num - ans) && v < ans) {
                ans = v;
            }
        }
        return String.valueOf(ans);
    }
}