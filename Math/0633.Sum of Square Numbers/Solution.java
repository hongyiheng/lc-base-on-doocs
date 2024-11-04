class Solution {
    public boolean judgeSquareSum(int c) {
        Set<Long> s = new HashSet<>();
        s.add(0L);
        for (long i = 0; i < (long)c + 1; i++) {
            if (i * i > c) {
                return false;
            }
            s.add(i * i);
            if (s.contains(c - i * i)) {
                return true;
            }
        }
        return false;
    }
}