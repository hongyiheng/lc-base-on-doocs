class Solution {
    public int f(String num, char t, Set<Character> ts) {
        int n = num.length();
        boolean flag = false;
        for (int i = n - 1; i > -1; i--) {
            char c = num.charAt(i);
            if (flag && ts.contains(c)) {
                return n - i - 2;
            }
            if (t == c) {
                flag = true;
            }
        }
        if (t == '0' && flag) {
            return n - 1;
        }
        return n;
    }

    public int minimumOperations(String num) {
        return Math.min(f(num, '0', new HashSet<>(Arrays.asList('0', '5'))), f(num, '5', new HashSet<>(Arrays.asList('2', '7'))));
    }
}