class Solution {
    public int countPrimeSetBits(int left, int right) {
        boolean[] dic = new boolean[32];
        int[] nums = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31};
        for (int i : nums) {
            dic[i] = true;
        }
        int ans = 0;
        for (int i = left; i <= right; i++) {
            int x = i, cnt = 0;
            while (x != 0) {
                x -= (x & -x);
                cnt++;
            }
            if (dic[cnt]) {
                ans++;
            }
        }
        return ans;
    }
}