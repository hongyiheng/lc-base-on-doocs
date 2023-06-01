class Solution {

    public boolean check(int[] price, int x, int k) {
        int last = price[0], cnt = 1;
        for (int i = 1; i < price.length; i++) {
            if (price[i] - last >= x) {
                cnt++;
                last = price[i];
            }
        }
        return cnt >= k;
    }

    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int l = 0, r = price[price.length - 1] - price[0];
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (check(price, mid, k)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
