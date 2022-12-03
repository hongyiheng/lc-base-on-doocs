class Solution {
    public int secondHighest(String s) {
        boolean[] nums = new boolean[10];
        for (char c : s.toCharArray()) {
            if ('0' <= c && c <= '9') {
                nums[c - '0'] = true;
            }
        }
        boolean flag = false;
        for (int i = 9; i > -1; i--) {
            if (nums[i]) {
                if (flag) {
                    return i;
                }
                flag = true;
            }
        }
        return -1;
    }
}
