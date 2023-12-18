class Solution {
    public String smallestString(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            if (cs[i] != 'a') {
                cs[i]--;
                flag = true;
            } else if (flag) {
                break;
            }
        }
        if (!flag) {
            cs[n - 1] = 'z';
        }
        return new String(cs);
    }
}