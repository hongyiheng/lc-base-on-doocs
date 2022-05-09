class Solution {
    public int[] diStringMatch(String s) {
        int n = s.length();
        int left = 0, right = n, idx = 0;
        int[] ans = new int[n + 1];
        for (int i = 0; i < n; i++) {
            ans[idx++] = s.charAt(i) == 'I' ? left++ : right--;
        }
        ans[idx] = left;
        return ans;
    }
}