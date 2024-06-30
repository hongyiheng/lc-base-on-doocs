class Solution {
    public int countKeyChanges(String s) {
        s = s.toLowerCase();
        int ans = 0;
        for (int i = 1; i < s.length(); i++) {
            char last = s.charAt(i - 1), cur = s.charAt(i);
            if ((last - 'a') % 26 != (cur - 'a') % 26) {
                ans++;
            }
        }
        return ans;
    }
}