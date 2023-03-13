class Solution {
    public String largestPalindromic(String num) {
        int n = num.length();
        int[] cnt = new int[10];
        for (char c : num.toCharArray()) {
            cnt[c - '0']++;
        }
        StringBuilder nums = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            if (nums.length() == 0 && i == 0) {
                break;
            }
            for (int j = 0; j < cnt[i] / 2; j++) {
                nums.append(i);
            }
            cnt[i] %= 2;
        }
        StringBuilder ans = new StringBuilder(nums);
        for (int i = 9; i >= 0; i--) {
            if (cnt[i] > 0) {
                ans.append(i);
                break;
            }
        }
        ans.append(nums.reverse());
        return ans.toString();
    }
}