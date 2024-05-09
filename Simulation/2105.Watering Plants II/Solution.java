class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int l = 0, r = plants.length - 1;
        int ac = capacityA, bc = capacityB, ans = 0;
        while (l <= r) {
            int lv = plants[l], rv = plants[r];
            if (l == r) {
                if (ac >= bc) {
                    if (lv > ac) {
                        ans++;
                    }
                } else {
                    if (lv > bc) {
                        ans++;
                    }
                }
            } else {
                if (lv > ac) {
                    ans++;
                    ac = capacityA;
                }
                if (rv > bc) {
                    ans++;
                    bc = capacityB;
                }
            }
            ac -= lv;
            bc -= rv;
            l++;
            r--;
        }
        return ans;
    }
}