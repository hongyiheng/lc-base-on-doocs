class Solution {
    public int[] findArray(int[] pref) {
        int n = pref.length;
        int[] ans = new int[n];
        int cur = 0;;
        for (int i = 0; i < n; i++) {
            ans[i] = cur ^ pref[i];
            cur ^= ans[i];
        }
        return ans;
    }
}
