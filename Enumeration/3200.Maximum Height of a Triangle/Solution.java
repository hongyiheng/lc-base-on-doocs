class Solution {
    public int maxHeightOfTriangle(int red, int blue) {
        int a = 0, b = 0;
        for (int i = 1; i <= 50; i++) {
            if (i % 2 != 0) {
                a += i;
            } else {
                b += i;
            }
            if (!(red >= a && blue >= b) && !(red >= b && blue >= a)) {
                return i - 1;
            }
        }
        return -1;
    }
}