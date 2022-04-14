class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long row = 0;
        for (int num : chalk) {
            row += num;
        }
        k %= row;
        for (int i = 0; i < chalk.length; i++) {
            if (k < chalk[i]) {
                return i;
            }
            k -= chalk[i];
        }
        return 0;
    }
}