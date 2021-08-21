class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int res = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (canPlant(flowerbed, i)) {
                flowerbed[i] = 1;
                res++;
            }
        }
        return res >= n;
    }

    public boolean canPlant(int[] flowerbed, int index) {
        if (flowerbed[index] == 1) {
            return false;
        }
        if (flowerbed.length == 1) {
            return true;
        }
        if (index == 0) {
            return flowerbed[index + 1] == 0;
        }
        if (index == flowerbed.length - 1) {
            return flowerbed[index - 1] == 0;
        }
        return flowerbed[index - 1] == 0 && flowerbed[index + 1] == 0;
    }
}