class Solution {
    public int[] closestDivisors(int num) {
        int mi = num + 1;
        int[] ans = new int[2];
        for (int i = 1; i * i <= num + 2; i++) {
            if ((num + 1) % i == 0) {
                if (Math.abs(i - (num + 1) / i) < mi) {
                    mi = Math.abs(i - (num + 1) / i);
                    ans[0] = i;
                    ans[1] = (num + 1) / i;
                }
            }
            if ((num + 2) % i == 0) {
                if (Math.abs(i - (num + 2) / i) < mi) {
                    mi = Math.abs(i - (num + 2) / i);
                    ans[0] = i;
                    ans[1] = (num + 2) / i;
                }
            }
        }
        return ans;
    }
}
