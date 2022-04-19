class Solution {
    public int[] shortestToChar(String s, char c) {
        List<Integer> chars = new ArrayList<>();
        char[] cs = s.toCharArray();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (cs[i] == c) {
                chars.add(i);
            }
        }
        int[] ans = new int[n];
        int idx = 0, left = -10010, right = chars.get(0);
        for (int i = 0; i < n; i++) {
            if (right < i && idx < chars.size() - 1) {
                left = right;
                right = chars.get(++idx);
            }
            ans[i] = Math.min(Math.abs(left - i), Math.abs(right - i));
        }
        return ans;
    }
}