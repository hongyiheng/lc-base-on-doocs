class Solution {
    public int nextGreaterElement(int n) {
        String s = String.valueOf(n);
        int m = s.length();
        if (m == 1) {
            return -1;
        }
        char[] cs = s.toCharArray();
        int i = m - 2;
        while (i >= 0) {
            if (cs[i] < cs[i + 1]) {
                break;
            }
            i--;
        }
        if (i < 0) {
            return -1;
        }
        int j = m - 1;
        while (j >= 0){
            if (cs[i] < cs[j]) {
                break;
            }
            j--;
        }
        if (j < 0) {
            return -1;
        }
        swap(cs, i, j);
        reverse(cs, i + 1);
        long ans = Long.parseLong(new String(cs));
        return ans > Integer.MAX_VALUE ? -1 : (int)ans;
    }

    public void reverse(char[] cs, int idx) {
        int i = idx, j = cs.length - 1;
        while (i < j) {
            swap(cs, i, j);
            i++;
            j--;
        }
    }

    public void swap(char[] cs, int i, int j) {
        char tmp = cs[i];
        cs[i] = cs[j];
        cs[j] = tmp;
    }
}