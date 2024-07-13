class Solution {
    public int minimumOperations(String num) {
        int n = num.length();
        boolean t = false, a1 = false;;
        int ans1 = n, ans2 = n;
        for (int i = n - 1; i >= 0; i--) {
            if (!t && num.charAt(i) == '5') {
                t = true;
                continue;
            }
            if (t && (num.charAt(i) == '2' || num.charAt(i) == '7')) {
                a1 = true;
                break;
            }
            ans1--;
        }

        t = false;
        for (int i = n - 1; i >= 0; i--) {
            if (t && (num.charAt(i) == '0' || num.charAt(i) == '5')) {
                break;
            }
            if (num.charAt(i) == '0') {
                t = true;
                continue;
            }
            ans2--;
        }
        return a1 ? n - Math.max(ans1, ans2) : n - ans2;
    }
}